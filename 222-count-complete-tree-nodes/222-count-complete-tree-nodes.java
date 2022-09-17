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
    int lefth(TreeNode root){
        return (root!=null) ? 1+lefth(root.left) : 0;
    }
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int l=lefth(root.left), r=lefth(root.right);
        if(l==r) return 1 + (1<<l)-1 + countNodes(root.right);
        else return 1 + (1<<r)-1 + countNodes(root.left);
    }
}

// ----------------------------------------------------------------------------
// class Solution {
//     public int countNodes(TreeNode root) {
//         int r=rDepth(root), l=lDepth(root);
//         if(r==l) return (int)Math.pow(2, r)-1;
//         else return countNodes(root.left) + countNodes(root.right) + 1;
//     }
//     int rDepth(TreeNode root){
//         int ans=0;
//         while(root!=null){
//             root=root.right;
//             ans++;
//         }
//         return ans;
//     }
//     int lDepth(TreeNode root){
//         int ans=0;
//         while(root!=null){
//             root=root.left;
//             ans++;
//         }
//         return ans;
//     }
// }