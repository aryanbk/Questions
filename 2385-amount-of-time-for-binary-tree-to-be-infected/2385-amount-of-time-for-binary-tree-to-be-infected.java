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
    Map<Integer, TreeNode> par;
    int start;
    TreeNode startNode;
    public int amountOfTime(TreeNode root, int start) {
        par = new HashMap<>();
        this.start = start;
        dfs(root, null);
        return bfs(startNode);
    }
    
    void dfs(TreeNode root, TreeNode parent){
        if(root==null) return;
        par.put(root.val, parent);
        if(root.val == start) startNode = root;
        dfs(root.left, root);
        dfs(root.right, root);
    }
    
    int bfs(TreeNode start){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(start);
        HashSet<Integer> vis = new HashSet<>();
        int lvl = 0;
        
        while(!q.isEmpty()){
            int l = q.size();
            
            for(int i=0; i<l; ++i){
                TreeNode node = q.poll();
                vis.add(node.val);
                
                if(node.left != null && !vis.contains(node.left.val))
                    q.offer(node.left);
                if(node.right != null &&  !vis.contains(node.right.val))
                    q.offer(node.right);
                if(par.get(node.val) != null && !vis.contains(par.get(node.val).val))
                    q.offer(par.get(node.val));
            }
            ++lvl;
        }
        
        return lvl-1;
    }
}