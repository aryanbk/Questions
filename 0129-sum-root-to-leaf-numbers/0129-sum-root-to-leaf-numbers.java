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
    public int sumNumbers(TreeNode root) {
        return (int)dfs(root, 0);
    }
    long dfs(TreeNode root, long cur){
        if(root.left == null && root.right == null)
            return (cur*10) + root.val;
        cur *= 10;
        cur += root.val;
        long ans = 0;
        if(root.left != null) ans += dfs(root.left, cur);
        if(root.right != null) ans += dfs(root.right, cur);
        return ans;
    }
}