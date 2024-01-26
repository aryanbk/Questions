class Solution {
    int[] dir = {0, 1, 0, -1, 0};
    int MOD = 1000000007;
    Integer[][][] dp = new Integer[51][51][51];
    
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if(maxMove < 0) return 0;
        if(startRow<0 || startColumn<0 || startRow>=m || startColumn>=n) return 1;
        
        if(dp[startRow][startColumn][maxMove] != null) return dp[startRow][startColumn][maxMove];
        
        int ans = 0;
        for(int x=0; x<4; ++x)
            ans = (ans + findPaths(m, n, maxMove-1, startRow+dir[x], startColumn+dir[x+1])) % MOD; 
        dp[startRow][startColumn][maxMove] = ans;
        return ans;
    }
}