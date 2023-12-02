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
class Solution {
    private int ans;
    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        dfs(root);
        return ans;
    }
    
    private int dfs(TreeNode root){
        if(root == null) return 0;
        
        int left = dfs(root.left);
        int right = dfs(root.right);
        
        ans = Math.max(ans, left+right+root.val);
        
        return Math.max(0, Math.max(left, right)+root.val);
    }
    
}