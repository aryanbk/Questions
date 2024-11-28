class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int MAX = 1000000000;
        var pq = new PriorityQueue<int[]>((a, b) -> a[0]-b[0]);
        pq.offer(new int[]{0, 0, 0});
        int[] dir = new int[]{0, -1, 0, 1, 0};
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int x = cur[1];
            int y = cur[2];
            int cost = cur[0] + grid[x][y];
            if(x==m-1 && y==n-1) return cost;
            grid[x][y] = MAX;
            
            for(int i=0; i<4; ++i){
                int a = x+dir[i];
                int b = y+dir[i+1];
                if(a>=0 && a<m && b>=0 && b<n && grid[a][b]!=MAX)
                    pq.offer(new int[]{cost, a, b});
            }
        }
        
        return -1;
    }
}