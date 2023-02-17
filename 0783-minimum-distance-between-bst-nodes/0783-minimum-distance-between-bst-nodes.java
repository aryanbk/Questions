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
    List<Integer> inOrder;
    public int minDiffInBST(TreeNode root) {
        inOrder = new ArrayList<>();
        help(root);
        int diff = Integer.MAX_VALUE;
        for(int i=0; i<inOrder.size()-1; ++i){
            diff = Math.min(diff, inOrder.get(i+1)-inOrder.get(i));
        }
        return diff;
    }
    private void help(TreeNode root){
        if(root==null) return;
        help(root.left);
        inOrder.add(root.val);
        help(root.right);
    }
}