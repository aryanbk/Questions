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
            int gcd = getGcd(ptr.val, ptr.next.val);
            var gcdNode = new ListNode(gcd, ptr.next);
            ptr.next = gcdNode;
            ptr = gcdNode.next;
        }
        return head;
    }
    
    int getGcd(int a, int b){
        return b==0 ? a : getGcd(b, a%b);
    }
}