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
    public boolean isValidBST(TreeNode root) {
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isBST(TreeNode node, long minValue, long maxValue) {
        if (node == null) return true;
        
        long nodeValue = node.val;
        if (nodeValue < minValue || nodeValue > maxValue)
            return false;
        
        boolean leftValid = isBST(node.left, minValue, nodeValue - 1);
        boolean rightValid = isBST(node.right, nodeValue + 1, maxValue);

        return leftValid && rightValid;
    }
}


// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
//     }
//     private boolean dfs(TreeNode root, long mn, long mx){
//         if(root==null)
//             return true;
        
//         long val = root.val;
//         if(val<mn || val>mx)
//             return false;
        
//         return dfs(root.left, mn, val-1) && dfs(root.right, val+1, mx);
//     }
// }