class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0]==0 ? 1 : 0;
        
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                if(i<m-1 && grid[i+1][j] != 1)
                    dp[i+1][j] += dp[i][j];
                if(j<n-1 && grid[i][j+1] != 1)
                    dp[i][j+1] += dp[i][j];
            }
        }
        
        return dp[m-1][n-1];
    }
}






// class Solution {
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         return travel(obstacleGrid, 0, 0, new int[obstacleGrid.length][obstacleGrid[0].length]);
//     }
//     int travel(int[][] grid, int i, int j, int[][] map){
//         if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==1) return 0;
//         if(i==grid.length-1 && j==grid[0].length-1) return 1;
//         if(map[i][j]==0) map[i][j]=travel(grid, i+1, j, map)+travel(grid, i, j+1, map);
//         return map[i][j];
//     }
// }