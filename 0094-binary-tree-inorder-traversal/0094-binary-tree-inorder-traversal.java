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

// Morris Traversal
//
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
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
                    temp.right = root;
                    root = root.left;
                }
                else{
                    temp.right = null;
                    ans.add(root.val);
                    root = root.right;
                }
                
            }
        }
        return ans;
    }
}

// // stk based iterative solution
// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//         var ans = new ArrayList<Integer>();
//         var stk = new Stack<TreeNode>();
//         while(true){
//             if(root != null){
//                 stk.push(root);
//                 root = root.left;
//             }else{
//                 if(stk.isEmpty())
//                     return ans;
//                 root = stk.pop();
//                 ans.add(root.val);
//                 root = root.right;
//             }
//         }
//     }
// }


// // recursion
//
// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//         if(root == null) return new ArrayList<>();
//         List<Integer> ans = new ArrayList<>();
//         ans.addAll(inorderTraversal(root.left));
//         ans.add(root.val);
//         ans.addAll(inorderTraversal(root.right));
//         return ans;
//     }
// }