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
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int l = q.size();
            TreeNode n = null;
            for(int i=0; i<l; i++){
                n = q.poll();
                if(n.left != null)
                    q.add(n.left);
                if(n.right != null)
                    q.add(n.right);
            }
            ans.add(n.val);
        }
        return ans;
    }
}