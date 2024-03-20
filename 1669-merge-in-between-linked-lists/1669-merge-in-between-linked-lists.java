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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode nx = list1;
        while(b-->-1) nx = nx.next;
        ListNode last = list2;
        while(last.next!=null) last = last.next;
        ListNode prev =  list1;
        while(a-->1) prev = prev.next;
        prev.next = list2;
        last.next = nx;
        return list1;
    }
}