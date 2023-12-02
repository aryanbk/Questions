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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] ans = {Integer.MIN_VALUE};
        dfs(root, ans);
        return ans[0];
    }
    private int dfs(TreeNode root, int[] ans){
        if(root == null) return 0;
        int left = dfs(root.left, ans);
        int right = dfs(root.right, ans);
        ans[0] = Math.max(ans[0], left+right);
        return Math.max(left, right)+1;
    }
}

// class Solution {
//     int ans = Integer.MIN_VALUE;
//     public int diameterOfBinaryTree(TreeNode root) {
//         dfs(root);
//         return ans;
//     }
//     private int dfs(TreeNode root){
//         if(root == null) return 0;
//         int left = dfs(root.left);
//         int right = dfs(root.right);
//         ans = Math.max(ans, left+right);
//         return Math.max(left, right)+1;
//     }
// }