// added seen in code, when seen == n while loop ends - it improves little bit
// removed x, y from pq, only index is sufficient

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int ans = 0, n = points.length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        pq.offer(new int[]{0, 0}); // cost, index
        boolean[] vis = new boolean[n];
        
        int seen = 0;
        
        while(!pq.isEmpty() && seen<n){
            
            int cost = pq.peek()[0];
            int idx = pq.peek()[1];
            pq.poll();
            
            if(vis[idx]) continue;
            vis[idx] = true;
            seen+=1;
            ans += cost;
            
            for(int p=0; p<n; ++p){
                if(vis[p]) continue;
                int newCost = Math.abs(points[p][0]-points[idx][0]) 
                    + Math.abs(points[p][1]-points[idx][1]);
                pq.offer(new int[]{newCost, p});
            }
        }
        
        return ans;
    }
}



// class Solution {
//     public int minCostConnectPoints(int[][] points) {
//         int ans = 0, n = points.length;
        
//         PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
//         pq.offer(new int[]{0, points[0][0], points[0][1], 0}); // cost, x, y, index
//         boolean[] vis = new boolean[n];
        
//         while(!pq.isEmpty()){
            
//             int cost = pq.peek()[0];
//             int i = pq.peek()[1];
//             int j = pq.peek()[2];
//             int idx = pq.peek()[3];
//             pq.poll();
            
//             if(vis[idx]) continue;
//             vis[idx] = true;
            
//             ans += cost;
            
//             for(int p=0; p<n; ++p){
//                 if(vis[p]) continue;
//                 int newCost = Math.abs(points[p][0]-i)+Math.abs(points[p][1]-j);
//                 pq.offer(new int[]{newCost, points[p][0], points[p][1], p});
//             }
//         }
        
//         return ans;
//     }
// }