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
    public ListNode modifiedList(int[] nums, ListNode head) {
        var set = new HashSet<Integer>();
        for(int n: nums) set.add(n);
        
        var dummy = new ListNode(-1, head);
        var ptr = dummy;
        while(ptr.next!=null){
            if(set.contains(ptr.next.val))
                ptr.next = ptr.next.next;
            else ptr = ptr.next;
        }
        
        return dummy.next;
    }
}