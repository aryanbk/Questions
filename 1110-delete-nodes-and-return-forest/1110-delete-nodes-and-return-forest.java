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
    HashSet<Integer> s;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        s = new HashSet<>();
        for(int d: to_delete) s.add(d);
        return dfs(root, null, false);
    }
    List<TreeNode> dfs(TreeNode root, TreeNode par, boolean left){
        if(root==null) return new ArrayList<>();
        var list = new ArrayList<TreeNode>();
        if(s.contains(root.val)){
            if(par!=null){
                if(left) par.left = null;
                else par.right = null;
            }
            if(root.left!=null) list.addAll(dfs(root.left, null, true));
            if(root.right!=null) list.addAll(dfs(root.right, null, false));
            
        }else{
            if(par==null) list.add(root);
            if(root.left!=null) list.addAll(dfs(root.left, root, true));
            if(root.right!=null) list.addAll(dfs(root.right, root, false));
        }
        return list;
    }
}