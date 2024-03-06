/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast=head,slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }
}


// public class Solution {
//     public boolean hasCycle(ListNode head) {
//         if(head == null || head.next == null) return false;
        
//         ListNode slow = head;
//         ListNode fast = head;
        
//         do{
//             slow = slow.next;
//             fast = fast.next.next;
//         }while(slow!=fast && slow.next!=null && fast.next!=null && fast.next.next!=null);
//         return slow==fast;
//     }
// }