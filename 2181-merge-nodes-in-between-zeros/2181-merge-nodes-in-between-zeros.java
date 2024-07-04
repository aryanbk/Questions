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
    public ListNode mergeNodes(ListNode head) {
        var ans = new ListNode(0);
        var ansPtr = ans;
        var ptr = head.next;
        
        while(ptr.next != null){
            if(ptr.val == 0){
                ansPtr.next = new ListNode(0);
                ansPtr = ansPtr.next;
            }
            ansPtr.val += ptr.val;
            ptr = ptr.next;
        }
        
        return ans;
    }
}