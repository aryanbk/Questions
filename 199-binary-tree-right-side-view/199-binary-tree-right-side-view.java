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
    List<Integer> ans;
    public List<Integer> rightSideView(TreeNode root) {
        ans=new ArrayList<>();
        rightF(root, 0);
        return ans;
    }
    void rightF(TreeNode node, int lvl){
        if(node==null) return;
        if(ans.size()==lvl) ans.add(node.val);
        rightF(node.right, lvl+1);
        rightF(node.left, lvl+1);
    }
}



// public class Solution {
//     public List<Integer> rightSideView(TreeNode root) {
//         // reverse level traversal
//         List<Integer> result = new ArrayList();
//         Queue<TreeNode> queue = new LinkedList();
//         if (root == null) return result;
        
//         queue.offer(root);
//         while (queue.size() != 0) {
//             int size = queue.size();
//             for (int i=0; i<size; i++) {
//                 TreeNode cur = queue.poll();
//                 if (i == 0) result.add(cur.val);
//                 if (cur.right != null) queue.offer(cur.right);
//                 if (cur.left != null) queue.offer(cur.left);
//             }
            
//         }
//         return result;
//     }
// }