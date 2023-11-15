class Solution {
    int m;
    int n;
    public int orangesRotting(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                if(grid[i][j] == 2)
                    q.offer(new int[]{i, j});
            }
        }
        
        int time = 0;
        // BFS
        while(!q.isEmpty()){
            int l = q.size();
            for(int a=0; a<l; ++a){                
                int i = q.peek()[0];
                int j = q.peek()[1];
                q.poll();
                
                for(int[] d: dir){
                    int x = i+d[0];
                    int y = j+d[1];
                    if(x<0 || x>=m || y<0 || y>=n || grid[x][y] != 1)
                        continue;
                    grid[x][y] = 2;
                    q.offer(new int[]{x, y});
                }
            }
            ++time;
        }
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                if(grid[i][j]==1)
                    return -1;
            }
        }
        return Math.max(time-1, 0);
    }
}