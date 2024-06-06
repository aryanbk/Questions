// push DP (forward DP)
//
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                if(i<m-1) dp[i+1][j] += dp[i][j];
                if(j<n-1) dp[i][j+1] += dp[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}





// class Solution {
//     public int uniquePaths(int m, int n) {
//        return travel(0,0,m,n,new int[m][n]);
//     }
//     int travel(int i, int j, int m , int n, int[][] map){
//         if(i<0 || i>=m || j<0 || j>=n) return 0;
//         if(i==m-1 && j==n-1)  return 1;
//         if(map[i][j]==0) map[i][j]=travel(i+1,j,m,n,map)+travel(i,j+1,m,n,map);
//         return map[i][j];
//     }
// }