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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        ListNode st = dummy;
        
        while(true){
            ListNode end = getEnd(st, k);

            if(end == null) return dummy.next;

            ListNode nx = end.next;
            end.next = null;
            
            ListNode rev = reverse(st.next);
            st.next = rev;
            end = getEnd(st, k);
            end.next = nx;

            st = end;
        }
    }
    
    ListNode reverse(ListNode node){
        ListNode prev = null;
        while(node!=null){
            ListNode nx = node.next;
            node.next = prev;
            prev = node;
            node = nx;
        }
        return prev;
    }
    
    ListNode getEnd(ListNode st, int k){ // return end by traversing k nodes
        ListNode end = st;
        for(int i=0; end!=null && i<k; ++i)
            end = end.next;
        return end;
    }
}