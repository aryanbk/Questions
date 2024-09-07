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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */




// KMP
class Solution {
    
    List<Integer> needle;
    int[] lps;
    public boolean isSubPath(ListNode head, TreeNode root) {
        needle = getList(head);
        lps = getLps();
        return find(root, 0);
    }
    
    ArrayList<Integer> getList(ListNode head){
        var ans = new ArrayList<Integer>(); // needle
        while(head != null){
            ans.add(head.val);
            head = head.next;
        }
        return ans;
    }
    
    int[] getLps(){
        int[] ans = new int[needle.size()]; // LPS
        for(int i=0, j=1; j<ans.length; ++j){
            if(needle.get(i) == needle.get(j)){
                ans[j] = i+1;
                ++i;
            }
            else if(i==0){
                ans[j] = 0;
            }
            else{
                i = ans[i-1];
                --j;
            }
        }
        return ans;
    }
    
    boolean find(TreeNode root, int j){
        if(j == needle.size()) return true;
        if(root == null) return false;
        if(root.val == needle.get(j))
            return find(root.left, j+1) || find(root.right, j+1);
        else if(j==0)
            return find(root.left, j) || find(root.right, j);
        else
            return find(root, lps[j-1]);
    }
}




// class Solution {
//     public boolean isSubPath(ListNode head, TreeNode root) {
//         if(root == null) return false;
//         return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
//     }
    
//     boolean dfs(ListNode head, TreeNode root){
//         if(head == null) return true;
//         if(root == null) return false;
//         boolean ans = false;
//         return head.val == root.val && (dfs(head.next, root.left) || dfs(head.next, root.right));
//     }
// }