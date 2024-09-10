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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        var ptr = head;
        while(ptr.next != null){
            var gcdNode = new ListNode(gcd(ptr.val, ptr.next.val), ptr.next);
            ptr.next = gcdNode;
            ptr = gcdNode.next;
        }
        return head;
    }
    
    int gcd(int a, int b){
        return b==0 ? a : gcd(b, a%b);
    }
}