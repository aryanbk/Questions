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
    Map<TreeNode, TreeNode> par;
    int st;
    int dt;
    TreeNode stNode;
    TreeNode dtNode;
    public String getDirections(TreeNode root, int start, int dest) {
        par = new HashMap<>(); 
        st = start;
        dt = dest;
        
        dfs(root);
        
        return dfs2(stNode, null, dtNode).reverse().toString();
    }
    void dfs(TreeNode root){
        if(root==null) return;
        if(root.val == st) stNode = root;
        if(root.val==dt) dtNode = root;
        if(root.left!=null){
            par.put(root.left, root);
            dfs(root.left);
        }
        if(root.right!=null){
            par.put(root.right, root);
            dfs(root.right);
        }
    }
    // StringBuilder bfs(TreeNode start, TreeNode dest){
    //     Queue<Cust> q = new LinkedList<>();
    //     q.offer()
    // }
    
    StringBuilder dfs2(TreeNode start, TreeNode prev, TreeNode dest){
        if(start==dest) return new StringBuilder();
        var sb = new StringBuilder();
        if(start.left != null && start.left!=prev){
            var left = dfs2(start.left, start, dest);
            if(left != null){
                left.append('L');
                return left;
            }
        }
        if(start.right != null && start.right != prev){
            var right = dfs2(start.right, start, dest);
            if(right != null){
                right.append('R');
                return right;
            }
        }
        var parent = par.getOrDefault(start, null);
        if(parent!=null && parent!=prev){
            var parentSb = dfs2(parent, start, dest);
            if(parentSb!=null){
                parentSb.append('U');
                return parentSb;
            }
        }
        
        return null;
    }
}

class Cust{
    TreeNode node;
    StringBuilder sb;
    public Cust(TreeNode node0, StringBuilder sb0){
        node = node0;
        sb = sb0;
    }
}