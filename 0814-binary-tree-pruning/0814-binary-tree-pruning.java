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
    public TreeNode pruneTree(TreeNode root) {
        if(root==null) return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        return (root.val==1 || root.left!=null || root.right!=null) ? root : null ;
    }
}

// class Solution {
//     public TreeNode pruneTree(TreeNode root) {
//         return dfs(root) ? root : null;
//     }
//     boolean dfs(TreeNode root){
//         if(root==null) return false;
//         boolean l = dfs(root.left);
//         boolean r = dfs(root.right);
//         if(!l) root.left=null;
//         if(!r) root.right=null;
//         return l || r || (root.val==1)?true:false;
//     }
// }


// // 2023
//
// class Solution {
//     public TreeNode pruneTree(TreeNode root) {
//         return prune(root) ? root : null; // to pass tree w/ only 0's
//     }
//     boolean prune(TreeNode root){
//         if(root==null)
//             return false;
//         boolean left = prune(root.left);
//         boolean right = prune(root.right);
        
//         if(!left)
//             root.left = null;
//         if(!right)
//             root.right = null;
//         return left || right || root.val==1;
//     }
// }