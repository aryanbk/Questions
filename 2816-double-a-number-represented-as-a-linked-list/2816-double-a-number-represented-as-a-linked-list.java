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
    public ListNode doubleIt(ListNode head) {
        ListNode rev = reverse(head);
        ListNode ptr = rev;
        int carry = 0;
        
        while(true){
            int sumt = (2*ptr.val)+carry;
            ptr.val = sumt%10;
            carry = sumt/10;
            if(ptr.next==null) break;
            ptr = ptr.next;
        }
        if(carry!=0){
            ListNode node = new ListNode(carry);
            ptr.next = node;
        }
        return reverse(rev);
    }
    
    ListNode reverse(ListNode cur){
        ListNode prev = null;
        while(cur != null){
            ListNode nx = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nx;
        }
        return prev;
    }
}