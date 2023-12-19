class Solution {
    public double knightProbability(int n, int k, int row, int col) {
        
        int[][] dir = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
        Double[][][] dp = new Double[k+1][n][n];
        for(var r: dp[0]) Arrays.fill(r, new Double(1));
        
        for(int x=1; x<=k; ++x){
            for(int i=0; i<n; ++i){
                for(int j=0; j<n; ++j){
                    
                    dp[x][i][j] = new Double(0);
                    
                    
                    for(int[] d: dir){
                        if(isValid(i+d[0], j+d[1], n))
                            dp[x][i][j] += dp[x-1][i+d[0]][j+d[1]];
                        
                        if(isValid(i+d[1], j+d[0], n))
                            dp[x][i][j] += dp[x-1][i+d[1]][j+d[0]];
                    }
                    dp[x][i][j] /= 8;
                }
            }
        }
        
        return dp[k][row][col];
    }
    
    boolean isValid(int i, int j, int n){
        return i>=0 && i<n && j>=0 && j<n;
    }
}



// class Solution {
//     int[][] dir = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
//     Double[][][] memo = new Double[26][26][101];
    
//     public double knightProbability(int n, int k, int i, int j) {
//         if(i<0 || i>=n || j<0 || j>=n)
//             return new Double(0);
        
//         if(k==0)
//             return new Double(1);
        
//         if(memo[i][j][k] != null) return memo[i][j][k];
        
//         memo[i][j][k] = new Double(0);
//         for(int[] d: dir){
//             memo[i][j][k] += knightProbability(n, k-1, i+d[0], j+d[1]);
//             memo[i][j][k] += knightProbability(n, k-1, i+d[1], j+d[0]);
//         }
        
//         memo[i][j][k] /= 8;
//         return memo[i][j][k];
//     }
// }