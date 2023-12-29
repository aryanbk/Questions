class Solution {
    public int minDifficulty(int[] dif, int d) {
        int n = dif.length;
        
        int[][] mxi = new int[n][n];
        for(int i=0; i<n; ++i){
            int curMx = dif[i];
            for(int j=i; j<n; ++j){
                curMx = Math.max(curMx, dif[j]);
                mxi[i][j] = curMx;
            }
        }
        
        
        int[][][] dp = new int[n+1][n+1][d+1];
        
        for(int i=n-1; i>=0; --i){
            for(int j=i; j<n; ++j){
                for(int k=0; k<=d; ++k){
                    if(k==0){
                        dp[i][j][k] = 1000000000;
                        continue;
                    }
                    if(k==1){
                        dp[i][j][k] = mxi[i][j];
                        continue;
                    }
                    if(i==j){
                        dp[i][j][k] = k==1 ? dif[i] : 1000000000;
                        continue;
                    }
                    
                    dp[i][j][k] = 1000000000;
                    for(int x=i; x<j; ++x){
                        int cur = Math.min(dp[i][x][1]+dp[x+1][j][k-1], 
                                          dp[i][x][k-1]+dp[x+1][j][1]);
                        dp[i][j][k] = Math.min(dp[i][j][k], cur);
                    }
                }
            }
        }
        
        return dp[0][n-1][d] != 1000000000 ? dp[0][n-1][d] : -1;
    }
}