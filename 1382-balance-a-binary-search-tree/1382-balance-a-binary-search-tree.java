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
    List<Integer> ino; // it will be sorted
    public TreeNode balanceBST(TreeNode root) {
        ino = new ArrayList<>();
        dfs(root);
        int n = ino.size();
        
        return makeTree(0, n-1);
    }
    
    void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);
        ino.add(root.val);
        dfs(root.right);
    }
    
    TreeNode makeTree(int i, int j){
        if(i>j) return null;
        int mid = i + (j-i)/2;
        
        TreeNode root = new TreeNode(ino.get(mid));
        root.left = makeTree(i, mid-1);
        root.right = makeTree(mid+1, j);
        
        return root;
    }
}





// // First attempt
// // wrong approch at building tree
//
// class Solution {
//     List<Integer> ino;
//     public TreeNode balanceBST(TreeNode root) {
//         ino = new ArrayList<>();
//         dfs(root);
//         int n = ino.size();
//         int idx = n/2;
//         TreeNode ans = new TreeNode(ino.get(idx));
        
//         TreeNode l = ans;
//         for(int i=idx-1; i>=0; --i){
//             l.left = new TreeNode(ino.get(i));
//             l = l.left;
//         }
//         TreeNode r = ans;
//         for(int i=idx+1; i<n; ++i){
//             r.right = new TreeNode(ino.get(i));
//             r = r.right;
//         }
        
//         return ans;
//     }
//     void dfs(TreeNode root){
//         if(root != null){
//             dfs(root.left);
//             ino.add(root.val);
//             dfs(root.right);
//         }
//     }
// }