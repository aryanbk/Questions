/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Node[] vis;
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        vis = new Node[101];
        vis[node.val] = new Node(node.val);
        return dfs(node, vis[node.val]);
    }
    
    Node dfs(Node node, Node ans){
        
        for(Node nbr: node.neighbors){
            if(vis[nbr.val]==null){
                vis[nbr.val] = new Node(nbr.val);
                ans.neighbors.add(vis[nbr.val]);
                dfs(nbr, vis[nbr.val]);
            }
            else
            ans.neighbors.add(vis[nbr.val]);
        }
        
        return ans;
    }
}