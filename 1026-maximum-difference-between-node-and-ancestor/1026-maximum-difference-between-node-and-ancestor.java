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
    int ans = 0;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return ans;
    }
    void dfs(TreeNode root, int mx, int mn){
        if(root==null) return;
        ans = Math.max(ans, Math.abs(mx - root.val));
        ans = Math.max(ans, Math.abs(mn - root.val));
        dfs(root.left, Math.max(mx, root.val), Math.min(mn, root.val));
        dfs(root.right, Math.max(mx, root.val), Math.min(mn, root.val));
    }
}