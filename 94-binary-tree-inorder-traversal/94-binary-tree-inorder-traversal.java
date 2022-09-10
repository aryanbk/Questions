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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stk=new Stack<>();
        List<Integer> ans = new ArrayList<>();
        while(true){
            if(root!=null){
                stk.push(root);
                root=root.left;
            }else{
                if(stk.isEmpty())
                    return ans;
                root=stk.pop();
                ans.add(root.val);
                root=root.right;
            }
        }
    }
}