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
        
       int l = length(head);
        head=reverseBetween(head, ((l + 1) / 2) + 1, l);
        int m = ((l + 1) / 2) + 1;
        ListNode f = head, s = head;
        while (m > 1) {
            f = f.next;
            m--;
        }
        while (f != null) {
            if (s.val != f.val) {
                return false;
            }
            s = s.next;
            f = f.next;
        }
        return true;
    }
    public int length(ListNode head) {
        int n = 1;
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
            n++;
        }
        return n;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head, newFirst = head;
        for (int i = 1; i < left + 1; i++) {
            prev = curr;
            curr = curr.next;
            if (i == left - 1) {
                newFirst = prev;
            }
        }
        ListNode newLast = prev;
        ListNode nx = curr.next;
        for (int i = 0; i < right - left; i++) {
            curr.next = prev;
            prev = curr;
            curr = nx;
            if (nx != null) {
                nx = nx.next;
            }
        }
        newLast.next = curr;
        newFirst.next = prev;
        return head;
    }
}