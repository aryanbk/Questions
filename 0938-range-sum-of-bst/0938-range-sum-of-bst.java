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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;
        
        boolean left = root.val>=low;
        boolean right = root.val<=high;
        
        int ans = 0;
        if(left && right) ans += root.val;
        if(left) ans += rangeSumBST(root.left, low, high);
        if(right) ans += rangeSumBST(root.right, low, high);
        
        return ans;
    }
}