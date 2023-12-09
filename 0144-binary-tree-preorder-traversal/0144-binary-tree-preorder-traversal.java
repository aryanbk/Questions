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
    public List<Integer> preorderTraversal(TreeNode root) {
        var ans = new ArrayList<Integer>();
        while(root != null){
            if(root.left == null){
                ans.add(root.val);
                root = root.right;
            }
            else{
                TreeNode temp = root.left;
                while(temp.right != null && temp.right != root){
                    temp = temp.right;
                }
                if(temp.right == null){
                    ans.add(root.val);
                    temp.right = root;
                    root = root.left;
                }
                else{
                    temp.right = null;
                    root = root.right;
                }
                
            }
        }
        return ans;
    }
}