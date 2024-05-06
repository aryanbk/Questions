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
    public ListNode removeNodes(ListNode head) {
        ListNode tail = rev(head);
        ListNode ptr = tail;
        ListNode prev = new ListNode(-1);
        
        while(ptr != null){
            ListNode nx = ptr.next;
            if(prev.val <= ptr.val){
                prev.next = ptr;
                ptr.next = null;
                prev = ptr;
            }
            ptr = nx;
        }
        
        return rev(tail);
    }
    
    ListNode rev(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null){
            ListNode nx = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nx;
        }
        return prev;
    }
}











// class Solution {
//     public ListNode removeNodes(ListNode head) {
//         ListNode tail = rev(head);
//         Stack<ListNode> stk = new Stack<>();
//         stk.add(tail);
//         ListNode ptr = tail.next;
//         tail.next = null;
//         // System.out.println(ptr.val);
        
//         while(ptr != null){
//             // while(!stk.isEmpty() && stk.peek().val < ptr.val)
//             //     stk.pop();
//             // System.out.println(ptr.val);
//             ListNode nx = ptr.next;
//             if(stk.peek().val <= ptr.val){
//                 stk.peek().next = ptr;
//                 ptr.next = null;
//                 stk.push(ptr);
//             }
//             ptr = nx;
//         }
        
//         return rev(tail);
//     }
    
//     ListNode rev(ListNode head){
//         ListNode prev = null;
//         ListNode cur = head;
//         while(cur != null){
//             ListNode nx = cur.next;
//             cur.next = prev;
//             prev = cur;
//             cur = nx;
//         }
//         return prev;
//     }
// }