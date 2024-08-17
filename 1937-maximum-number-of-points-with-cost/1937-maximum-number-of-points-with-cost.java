class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long[] dpPrev = new long[n];
        
        for(int i=0; i<m; ++i){
            long[] dp = new long[n];

            long curMx = 0;
            for(int j=0; j<n; ++j)
                dp[j] = curMx = Math.max(curMx-1, dpPrev[j]);
            
            curMx = 0;
            for(int j=n-1; j>=0; --j){
                curMx = Math.max(curMx-1, dpPrev[j]);
                dp[j] = Math.max(dp[j], curMx) + points[i][j];
            }
            dpPrev = dp;
        }
        long ans = 0;
        for (long x: dpPrev) ans = Math.max(ans, x);
        return ans;
    }
    
}



// class Solution {
//     int m;
//     int n;
//     Long[][] cache;
//     public long maxPoints(int[][] points) {
//         m = points.length;
//         n = points[0].length;
//         cache = new Long[m][n];
        
//         long ans = 0;
//         for(int j=0; j<n; ++j) ans = Math.max(ans, solve(1, j, points)+points[0][j]);
//         return ans;
//     }
//     long solve(int i, int prevJ, int[][] points){
//         if(i==m) return 0;
        
//         if(prevJ != -1 && cache[i][prevJ]!=null) return cache[i][prevJ];
        
//         long ans = 0;
//         for(int j=0; j<n; ++j){
//             long curAns = solve(i+1, j, points) + points[i][j];
//             if(j!=prevJ && prevJ!=-1) curAns -= Math.abs(j-prevJ);
//             ans = Math.max(ans, curAns);
//         }
//         if(prevJ != -1) cache[i][prevJ] = ans;
//         return ans;
//     }
// }