/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> listP =new ArrayList<>();
        helper(root,p,listP);
        List<TreeNode> listQ =new ArrayList<>();
        helper(root,q,listQ);
        int i=0;
        while(i<listP.size() && i<listQ.size() && listP.get(i).val==listQ.get(i).val)
            i++;
        return listP.get(i-1);
    }
    boolean helper(TreeNode root, TreeNode p, List<TreeNode> list){
        if(root==null) return false;
        list.add(root);
        if(root.val==p.val) return true;
        if(helper(root.left,p,list) || helper(root.right,p,list))
            return true;
        list.remove(list.size()-1);
        return false;
    }
}