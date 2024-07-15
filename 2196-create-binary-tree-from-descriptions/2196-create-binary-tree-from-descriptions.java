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
    public TreeNode createBinaryTree(int[][] desc) {
        var map = new HashMap<Integer, TreeNode>(); // number to Node
        var par = new HashMap<Integer, Boolean>(); // Node has parents or not
        
        for(var d: desc){
            map.putIfAbsent(d[0], new TreeNode(d[0]));
            map.putIfAbsent(d[1], new TreeNode(d[1]));
            par.putIfAbsent(d[0], false);
            par.put(d[1], true);
            if(d[2]==1) map.get(d[0]).left = map.get(d[1]);
            else map.get(d[0]).right = map.get(d[1]);
        }
        
        for(var k: par.keySet()){
            if(!par.get(k)) return map.get(k); // if it doesn't has parents then its root
        }
        
        return null;
    }
}