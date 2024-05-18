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
    public int distributeCoins(TreeNode root) {
        return dfs(root)[0];
    }
    
    int[] dfs(TreeNode root){
        if(root == null) return new int[]{0, 0};
        int[] ret = new int[]{0, 0};
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        ret[1] = l[1] + r[1] + 1 - root.val;
        ret[0] = Math.abs(l[1]) + Math.abs(r[1]) + l[0] + r[0];
        return ret;
    }
}










// class Solution {
//     Map<TreeNode, TreeNode> map;
//     public int distributeCoins(TreeNode root) {
//         map = new HashMap<>();
//         map.put(root, null);
//     }
    
//     int dfs(TreeNode root, TreeNode og){
//         if(root == null) return 0;
//         int temp = root.val;
//         int lft = 0;
//         int rt = 0;
//         int up = 0;
//         if(root.left != og){
//             lft = dfs(root.left, root);
//             // root.left.val = lft;
//         }
//         if(root.right != og){
//             rt = dfs(root.right, root);
//             // root.right.val = rt;
//         }
//         if(map.get(root) != og){
//             up = dfs(map.get(root), root);
//             // map.get(root).val = up;
//         }
//         root.val = temp - lft - rt - up;
//         int ans = Math.abs(temp - root.val);
        
//     }
// }