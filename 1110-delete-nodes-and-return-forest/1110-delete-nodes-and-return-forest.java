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
    List<TreeNode> list;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        s = new HashSet<>();
        list = new ArrayList<>();
        for(int d: to_delete) s.add(d);
        dfs(root, null, false);
        return list;
    }
    void dfs(TreeNode root, TreeNode par, boolean left){
        if(root==null) return;
        TreeNode cur = s.contains(root.val) ? null : root;
        if(s.contains(root.val)){
            if(par!=null){
                if(left) par.left = null;
                else par.right = null;
            }
        }
        else{
            if(par==null) list.add(root);
        }
        dfs(root.left, cur, true);
        dfs(root.right, cur, false);
    }
}


// class Solution {
//     HashSet<Integer> s;
//     List<TreeNode> list;
//     public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
//         s = new HashSet<>();
//         list = new ArrayList<>();
//         for(int d: to_delete) s.add(d);
//         dfs(root, null, false);
//         return list;
//     }
//     void dfs(TreeNode root, TreeNode par, boolean left){
//         if(root==null) return;
//         if(s.contains(root.val)){
//             if(par!=null){
//                 if(left) par.left = null;
//                 else par.right = null;
//             }
//             dfs(root.left, null, true);
//             dfs(root.right, null, false);
//         }else{
//             if(par==null) list.add(root);
//             dfs(root.left, root, true);
//             dfs(root.right, root, false);
//         }
//     }
// }