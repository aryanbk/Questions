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
    List<Long> list;
    public TreeNode replaceValueInTree(TreeNode root) {
        list = new ArrayList<>();
        var q = new LinkedList<TreeNode>();
        q.offer(root);
        
        while(!q.isEmpty()){
            int l = q.size();
            long sumt = 0;
            for(int i=0; i<l; ++i){
                TreeNode node = q.poll();
                sumt += node.val;
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            list.add(sumt);
        }
        
        System.out.println(list);
        root.val = 0;
        dfs(root, 0);
        return root;
    }
    
    void dfs(TreeNode root, int lvl){
        if(lvl == list.size()-1) return;
        
        long sumt = 0;
        if(root.left != null) sumt += root.left.val;
        if(root.right != null) sumt += root.right.val;
        long newVal = list.get(lvl+1) - sumt;
        
        if(root.left != null){
            root.left.val = (int)newVal;
            dfs(root.left, lvl+1);
        }
        if(root.right != null){
            root.right.val = (int)newVal;
            dfs(root.right, lvl+1);
        }
    }
}