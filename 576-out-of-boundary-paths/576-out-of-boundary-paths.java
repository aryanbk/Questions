class Solution {
    int[][][] dp;
    int x;
    int y;
    int[] dir = {1,0,-1,0,0,1,0,-1};
    int a=1000000007;
    public int findPaths(int m, int n, int move, int r, int c) {
        x=m;
        y=n;
        dp=new int[x][y][move+1];
        for (int ii = 0; ii < m; ii++) {
            for (int jj = 0; jj < n; jj++) {
                for (int kk = 0; kk < move+1; kk++) {
                    dp[ii][jj][kk] = -1;
                }
            }
        }
        return dfs(r, c, move);
    }
    int dfs(int i, int j, int move){
        if(i<0 || j<0 || i>=x || j>=y) return 1;
        if(move<=0) return 0;
        if(dp[i][j][move]!=-1) return dp[i][j][move];
        dp[i][j][move]=0;
        for(int p=0; p<4; p++){
            dp[i][j][move] = (dp[i][j][move] + dfs(i+dir[p],j+dir[p+4], move-1)%a ) %a;
        }
        return dp[i][j][move];
    }
}