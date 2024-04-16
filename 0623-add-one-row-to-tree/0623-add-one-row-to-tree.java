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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        TreeNode newRoot = new TreeNode(0, root, null);
        dfs(newRoot, val, depth);
        return newRoot.left;
    }
    void dfs(TreeNode root, int val, int depth){
        if(root==null || depth<1) return;
        if(depth == 1){
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = new TreeNode(val, left, null);
            root.right = new TreeNode(val, null, right);
            return;
        }
        dfs(root.left, val, depth-1);
        dfs(root.right, val, depth-1);
    }
    
}