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
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null)
            return head;
        
        ListNode hn=head.next;
        ListNode hnn=hn.next;
        
        hn.next=head;
        head.next = swapPairs(hnn);
        return hn;
    }
}


// class Solution {
//     public ListNode swapPairs(ListNode head) {
//         return helper(head, head);
//     }
//     ListNode helper(ListNode head , ListNode node){
        
//         if(node==null || node.next==null){
//             return head;
//         }
//         int temp=node.val;
//         node.val=node.next.val;
//         node.next.val=temp;
//         return helper(head, node.next.next);
//     }
// }