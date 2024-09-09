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
    ListNode head;
    
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        this.m = m;
        this.n = n;
        this.head = head;
        
        ans = new int[m][n];
        for(var a: ans) Arrays.fill(a, -1);
        
        fill(0);
        return ans;
    }
    
    void fill(int i){
        if(i>m-i-1 || i>n-i-1) return;
        
        for(int x=i; x<n-i && head!=null; ++x, head = head.next)
            ans[i][x] = head.val;
        
        for(int x=i+1; x<m-i-1 && head!=null; ++x, head = head.next)
            ans[x][n-i-1] = head.val;
        
        for(int x=n-i-1; i!=m-i-1 && x>=i && head!=null; --x, head = head.next)
            ans[m-i-1][x] = head.val;
        
        for(int x=m-i-2; i!=n-i-1 && x>i && head!=null; --x, head=head.next)
            ans[x][i] = head.val;
        
        fill(i+1);
    }
}