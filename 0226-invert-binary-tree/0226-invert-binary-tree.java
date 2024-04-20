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
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if(node.left != null) q.offer(node.left);
            if(node.right != null) q.offer(node.right);
        }
        
        return root;
    }
}



// class Solution {
//     public TreeNode invertTree(TreeNode root) {
//         if(root==null) return root;
//         TreeNode temp = root.left;
//         root.left = invertTree(root.right);
//         root.right = invertTree(temp);
//         return root;
//     }
// }