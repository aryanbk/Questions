class Solution {
    public int minCostConnectPoints(int[][] points) {
        int ans = 0, n = points.length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[2]));
        pq.offer(new int[]{points[0][0], points[0][1], 0, 0});
        boolean[] vis = new boolean[n];
        
        while(!pq.isEmpty()){
            int i = pq.peek()[0];
            int j = pq.peek()[1];
            int dis = pq.peek()[2];
            int idx = pq.peek()[3];
            pq.poll();
            
            if(vis[idx]) continue;
            vis[idx] = true;
            
            ans += dis;
            
            for(int p=0; p<n; ++p){
                if(p==idx) continue;
                int newDis = Math.abs(points[p][0]-i)+Math.abs(points[p][1]-j);
                pq.offer(new int[]{points[p][0], points[p][1], newDis, p});
            }
        }
        
        return ans;
    }
}