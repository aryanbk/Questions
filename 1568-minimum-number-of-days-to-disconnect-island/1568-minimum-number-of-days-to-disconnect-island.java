class Solution {
    int m;
    int n;
    boolean[][] vis;
    int[] dir = {0, 1, 0, -1, 0};
    
    public int minDays(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        // int numOfIslandBefore = numOfIsland(grid);
        // if(numOfIslandBefore==0 || numOfIslandBefore==2) return 0;
        if(numOfIsland(grid) != 1) return 0;
        
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                if(grid[i][j] == 1){
                    grid[i][j] = 0;
                    int curNumOfIsland = numOfIsland(grid);
                    if(curNumOfIsland != 1) return 1;
                    grid[i][j] = 1;
                }
            }
        }
        
        return 2;
    }
    
    int numOfIsland(int[][] grid){
        vis = new boolean[m][n];
        int ans = 0;
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                ans += dfs(i, j, grid) ? 1 : 0;
            }
        }
        return ans;
    }
    
    boolean dfs(int i, int j, int[][] grid){
        if(i<0 || j<0 || i>=m || j>=n || vis[i][j] || grid[i][j]==0) return false;
        boolean ans = true;
        vis[i][j] = true;
        for(int x=0; x<4; ++x)
            ans |= dfs(i+dir[x], j+dir[x+1], grid);
        return ans;
    }
}