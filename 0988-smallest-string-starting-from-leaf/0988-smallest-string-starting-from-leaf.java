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
    PriorityQueue<StringBuilder> pq = new PriorityQueue<>((a, b) -> b.compareTo(a));
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return pq.poll().toString();
    }
    void dfs(TreeNode root, StringBuilder sb){
        if(root.left==null && root.right==null){
            sb.append((char)('a'+root.val));
            pq.offer(sb.reverse());
            if(pq.size() > 1) pq.poll();
            return;
        }
        StringBuilder left = new StringBuilder(sb);
        left.append((char)('a'+root.val));
        if(root.left!=null) dfs(root.left, left);
        StringBuilder right = new StringBuilder(sb);
        right.append((char)('a'+root.val));
        if(root.right!=null) dfs(root.right, right);
        // System.out.println(right);
        return;
    }
}