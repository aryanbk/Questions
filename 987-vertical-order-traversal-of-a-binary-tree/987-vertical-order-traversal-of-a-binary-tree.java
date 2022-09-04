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
class Point{
    int x,y,val;
    Point(int x,int y,int val){
        this.x = x;
        this.y = y;
        this.val = val;
    }
}
public class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        PriorityQueue<Point> pq = new PriorityQueue<Point>(1005,new Comparator<Point>(){
            public int compare(Point p1,Point p2){
                if(p1.x < p2.x) return -1;
                if(p2.x < p1.x) return 1;
                if(p1.y > p2.y) return -1;
                if(p1.y < p2.y) return 1;
                return p1.val - p2.val;
            }
        });
        
        verticalTraversalHelper(root,0,0,pq);
        Point prev = null;        
        List<Integer> l = new ArrayList<>();
        while(!pq.isEmpty()){
            Point p = pq.poll();
            if(prev == null || p.x != prev.x){
                if(prev != null) res.add(l);
                l = new ArrayList<>();
            }
            l.add(p.val);
          prev = p;
        }
        
        res.add(l);
        return res;
    }
    
    private void verticalTraversalHelper(TreeNode root,int x,int y,PriorityQueue<Point> pq){
        if(root == null) return;
        pq.offer(new Point(x,y,root.val));
        verticalTraversalHelper(root.left,x-1,y-1,pq);
        verticalTraversalHelper(root.right,x+1,y-1,pq);
    }
}