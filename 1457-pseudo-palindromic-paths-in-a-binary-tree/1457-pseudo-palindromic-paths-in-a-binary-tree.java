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
    public int pseudoPalindromicPaths (TreeNode root) {
        return dfs(root, new boolean[10]);
    }
    int dfs(TreeNode root, boolean[] map){
        if(root.left==null && root.right==null){
            map[root.val] ^= true;
            int odd = 0;
            for(var m: map) odd += m ? 1 : 0;
            map[root.val] ^= true;
            return odd < 2 ? 1 : 0;
        }
        map[root.val] ^= true;
        int ans = 0;
        if(root.left != null) ans += dfs(root.left, map);
        if(root.right != null) ans += dfs(root.right, map);
        map[root.val] ^= true;
        return ans;
    }
}





// class Solution {
//     public int pseudoPalindromicPaths (TreeNode root) {
//         return dfs(root, new HashMap<>());
//     }
//     int dfs(TreeNode root, Map<Integer, Integer> map){
//         if(root.left==null && root.right==null){
//             map.put(root.val, map.getOrDefault(root.val, 0)+1);
//             // System.out.println(map);
//             int odd = 0;
//             for(int key: map.keySet()){
//                 odd += map.get(key)%2;
//             }
//             map.put(root.val, map.get(root.val)-1);
//             return odd < 2 ? 1 : 0;
//         }
//         map.put(root.val, map.getOrDefault(root.val, 0)+1);
//         int ans = 0;
//         if(root.left != null) ans += dfs(root.left, map);
//         if(root.right != null) ans += dfs(root.right, map);
//         map.put(root.val, map.get(root.val)-1);
//         return ans;
//     }
// }