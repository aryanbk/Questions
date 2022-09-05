/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if(root==null) return new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        List<List<Integer>> ans=new ArrayList<>();
        while(!q.isEmpty()){
            int l=q.size();
            List<Integer> list=new ArrayList<>();
            for( int x=0; x<l; x++){
                Node node = q.poll();
                list.add(node.val);
                for(int i=0; i<node.children.size(); i++)
                    q.offer(node.children.get(i));
            }
            ans.add(list);
        }
        return ans;
    }
}