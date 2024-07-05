/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        var ptr = head.next;
        int prev = head.val;
        
        int critCur = -1;
        int critFirst = -1;
        
        int[] ans = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        int i = 1;
        
        while(ptr.next != null){
            int nx = ptr.next.val;
            int cur = ptr.val;
            
            if((prev<cur && nx<cur) || (prev>cur && nx>cur)){
                if(critFirst == -1)
                    critFirst = i;
                else{
                    ans[0] = Math.min(ans[0], i-critCur);
                    ans[1] = Math.max(ans[1], i-critFirst);
                }
                critCur = i;
            }
            
            prev = ptr.val;
            ptr = ptr.next;
            ++i;
        }
        
        return critCur == critFirst ? new int[]{-1, -1} : ans;
    }
}