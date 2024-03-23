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
    public void reorderList(ListNode head) {
        ListNode head1 = head;
        ListNode head2 = solve(head);
        while(head2!=null){
            ListNode nx1 = head1.next;
            ListNode nx2 = head2.next;
            head1.next = head2;
            head2.next = nx1;
            head1 = nx1;
            head2 = nx2;
        }
    }
    public ListNode solve(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        return reverseList(head2);
    }
    public ListNode reverseList(ListNode head) {
        if(head==null) return head;
        ListNode prev = null;
        ListNode cur = head;
        ListNode nx = head.next;
        
        while(cur != null){
            cur.next = prev;
            prev = cur;
            cur = nx;
            if(nx!=null)
                nx = nx.next;
        }
        return prev;
    }
}