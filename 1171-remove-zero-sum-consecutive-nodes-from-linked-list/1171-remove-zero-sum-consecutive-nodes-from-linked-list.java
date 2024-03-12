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
    public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer, ListNode> map = new HashMap<>();
        int sumt = 0;
        ListNode pre = new ListNode(0, head);
        ListNode ptr = pre;
        
        while(ptr!=null){
            sumt += ptr.val;
            if(map.containsKey(sumt)){
                ListNode tmp = map.get(sumt).next;
                int tmpSum = sumt;
                while(tmp != ptr){
                    tmpSum += tmp.val;
                    map.remove(tmpSum);
                    tmp = tmp.next;
                }
                map.get(sumt).next = ptr.next;
            }
            else{
                map.put(sumt, ptr);
            }
            ptr = ptr.next;
        }
        return pre.next;
    }
}