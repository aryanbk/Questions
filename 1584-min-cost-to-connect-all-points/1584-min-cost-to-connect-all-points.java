class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int seen = 0;
        int cost = 0;
        
        boolean[] vis = new boolean[n];
        var pq = new PriorityQueue<int[]>((a, b) -> a[0]-b[0]);
        pq.offer(new int[]{0, 0}); // cost, index
        
        while(!pq.isEmpty() && seen < n){
            int[] cur = pq.poll();
            int idx = cur[1];
            
            if(vis[idx]) continue;
            vis[idx] = true;
            cost += cur[0]; 
            ++seen;
            
            for(int i=0; i<n; ++i){
                if(!vis[i]){
                    int dist = Math.abs(points[i][0] - points[idx][0]) + Math.abs(points[i][1] - points[idx][1]);
                    pq.offer(new int[]{dist, i});
                }
            }
        }
        
        return cost;
    }
}