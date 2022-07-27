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
    public void flatten(TreeNode root) {
        if(root==null) return;
        TreeNode left=root.left;
        if(left==null){
            flatten(root.right);
            return;
        }
        TreeNode ptr=root.left;
        while(ptr.right!=null) ptr=ptr.right;
        TreeNode right=root.right;
        root.right=left;
        ptr.right=right;
        root.left=null;
        flatten(root.right);
        return;
    }
}