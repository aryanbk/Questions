
class Solution {
    public int minFallingPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[m-1] = grid[m-1];

        for(int i=m-2; i>=0; --i){
            for(int j=0; j<n; ++j){
                dp[i][j] = 1000_000_000;
                for(int x=0; x<m; ++x){
                    if(x!=j) dp[i][j] = Math.min(dp[i][j], dp[i+1][x]);
                }
                dp[i][j] += grid[i][j];
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for(int d: dp[0]) ans = Math.min(ans, d);
        return ans;
    }
}






// // mis-understood the question
//
// class Solution {
//     Integer[][] dp;
//     public int minFallingPathSum(int[][] grid) {
//         dp = new Integer[grid.length][grid[0].length];
//         int ans = Integer.MAX_VALUE;
//         for(int i=0; i<grid[0].length; ++i)
//             ans = Math.min(ans, dfs(0, i, grid));
        
//         return ans;
//     }
//     int dfs(int i, int j, int[][] grid){
//         if(i==grid.length) return 0;
        
//         if(dp[i][j] != null) return dp[i][j];
        
//         int ans = 1000000000;
//         if(j>0) ans = Math.min(ans, dfs(i+1, j-1, grid)+grid[i][j]);
//         if(j<grid[0].length-1) ans = Math.min(ans, dfs(i+1, j+1, grid)+grid[i][j]);
//         if(ans >= 1000000000) ans = grid[i][j];
//         // ans += grid[i][j];
        
//         dp[i][j] = ans;
        
//         return ans;
//     }
// }