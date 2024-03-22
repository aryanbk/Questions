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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        head2 = reverseList(head2);
        while(head!=null && head2!=null && head.val==head2.val){
            head = head.next;
            head2 = head2.next;
        }
        return head2==null;
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