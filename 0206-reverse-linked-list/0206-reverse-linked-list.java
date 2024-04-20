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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while(head != null){
            ListNode nx = head.next;
            head.next = prev;
            prev = head;
            head = nx;
        }
        return prev;
    }
}

//     public ListNode reverseList(ListNode head) {
//         if(head==null) return head;
//         ListNode prev = null;
//         ListNode cur = head;
//         ListNode nx = head.next;
        
//         while(cur != null){
//             cur.next = prev;
//             prev = cur;
//             cur = nx;
//             if(nx!=null)
//                 nx = nx.next;
//         }
//         return prev;
//     }
// }