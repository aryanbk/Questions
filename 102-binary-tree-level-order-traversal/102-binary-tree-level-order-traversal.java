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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root==null) return list;
        Queue<TreeNode> q= new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            int l=q.size();
            List<Integer> a=new ArrayList<>();
            for(int i=0; i<l; i++){
                TreeNode pres= q.poll();
                a.add(pres.val);
                if(pres.left!=null) q.add(pres.left);
                if(pres.right!=null) q.add(pres.right);
            }
            list.add(a);
        }
        return list;
    }
}