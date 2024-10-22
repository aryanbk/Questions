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
    public long kthLargestLevelSum(TreeNode root, int k) {
        var pq = new PriorityQueue<Long>();
        var q = new LinkedList<TreeNode>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            long sumt = 0;
            for(int i=0; i<size; ++i){
                TreeNode node = q.poll();
                sumt += node.val;
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            pq.offer(sumt);
            if(pq.size()>k) pq.poll();
        }
        
        return pq.size()==k ? pq.poll() : -1;
    }
}