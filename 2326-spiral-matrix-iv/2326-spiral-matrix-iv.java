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
    int[][] ans;
    int m;
    int n;
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        ans = new int[m][n];
        this.m = m;
        this.n = n;
        fill(0, 0, head);
        return ans;
    }
    void fill(int i, int j, ListNode head){
        System.out.println("fill "+i+" "+j);
        if(i>m-i-1 || i>n-i-1) return;
        
        for(int x=j; x<n-j; ++x){
            // if(head == null){
            //     ans[i][x] = -1;
            //     continue;
            // }
            // ans[i][x] = head.val;
            // head = head.next;
            head = add(i, x, head);
        }
        for(int x=i+1; x<m-i-1; ++x){
            // if(head==null)
            head = add(x, n-i-1, head);
        }
        for(int x=n-j-1; i!=m-j-1 && x>=j; --x){
            head = add(m-i-1, x, head);
        }
        for(int x=m-i-2; i!=n-i-1 && x>i; --x)
            head = add(x, i, head);
        
        fill(i+1, i+1, head);
    }
    
    ListNode add(int i, int j, ListNode head){
        if(head==null){
            System.out.println(i+" "+j+" null");
            ans[i][j] = -1;
            return head;
        }
        System.out.println(i+" "+j+" "+head.val);
        ans[i][j] = head.val;
        return head.next;
    }
}