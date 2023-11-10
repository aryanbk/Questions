class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[2]));
        pq.add(new int[]{0, 0, 0});
        
        int[][] effort = new int[n][m];
        for(int[] e: effort)
            Arrays.fill(e, Integer.MAX_VALUE);
        
        while(!pq.isEmpty()){
            int i = pq.peek()[0];
            int j = pq.peek()[1];
            int eff = pq.peek()[2];
            pq.poll();
            
            if(eff > effort[i][j])
                continue;
            effort[i][j] = eff; //for heights = [[3]] testcase
            
            for(int d=0; d<4; ++d){
                int x = i+dx[d];
                int y = j+dy[d];
                if(x>=0 && x<n && y>=0 && y<m){
                    int newEff = Math.max(eff, Math.abs(heights[i][j] - heights[x][y]));
                    if(newEff < effort[x][y]){
                        effort[x][y] = newEff;
                        pq.offer(new int[]{x, y, newEff});
                    }
                }
                
            }
        }
        return effort[n-1][m-1];
    }
}