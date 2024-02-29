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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean even = true;
        
        while(!q.isEmpty()){
            int n = q.size();
            int prev = even ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            for(int i=0; i<n; ++i){
                TreeNode node = q.poll();
                if(even && (prev>=node.val || node.val%2==0)) return false;
                if(!even && (prev<=node.val || node.val%2==1)) return false;
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
                prev = node.val;
            }
            even ^= true;
        }
        
        return true;
    }
}