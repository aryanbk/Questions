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
    int m=0;
    public int diameterOfBinaryTree(TreeNode root) {
        int a=maxDepth(root);
        return m;
    }
    int maxDepth(TreeNode root){
        if(root==null) return 0;
        int left=maxDepth(root.left), right=maxDepth(root.right);
        m=Math.max(m, left+right);
        return Math.max(left,right)+1;
    }
}