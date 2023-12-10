class Solution {
    public int stoneGameV(int[] val) {
        
        int n = val.length;
        int[][] dp = new int[n+1][n+1];
        
        int[] pre = new int[n+1];
        for(int i=1; i<=n; ++i) pre[i] = pre[i-1] + val[i-1];
        
        for(int i=n-1; i>=0; --i){
            for(int j=i+1; j<n; ++j){
                int ans = 0;
                for(int k=i; k<j; ++k){
                    int sumt1 = pre[k+1] - pre[i];
                    int sumt2 = pre[j+1] - pre[k+1];

                    if(sumt1 < sumt2){
                        ans = Math.max(ans, sumt1 + dp[i][k]);
                    }
                    else if(sumt1 > sumt2){
                        ans = Math.max(ans, sumt2 + dp[k+1][j]);
                    }
                    else{
                        int newAns = Math.max(dp[i][k], dp[k+1][j]) + sumt1;
                        ans = Math.max(ans, newAns);
                    }
                }

                dp[i][j] = ans;
            }
        }
        
        
        return dp[0][n-1];
    }
}


// // DP - memo O(n*n)
//
// class Solution {
//     int[] pre;
//     int[][] memo;
    
//     public int stoneGameV(int[] val) {
//         int n = val.length;
        
//         pre = new int[n+1];
//         for(int i=1; i<=n; ++i) pre[i] = pre[i-1] + val[i-1];
        
//         memo = new int[n+1][n+1];
//         for(int[] row: memo) Arrays.fill(row, -1);
        
//         return mcm(0, n-1, val);
//     }
    
//     private int mcm(int i, int j, int[] val){
//         if(i>=j) return 0;
//         if(memo[i][j] != -1) return memo[i][j];
        
//         int ans = 0;
//         for(int k=i; k<j; ++k){
//             int sumt1 = pre[k+1] - pre[i];
//             int sumt2 = pre[j+1] - pre[k+1];
            
//             if(sumt1 < sumt2){
//                 ans = Math.max(ans, sumt1 + mcm(i, k, val));
//             }
//             else if(sumt1 > sumt2){
//                 ans = Math.max(ans, sumt2 + mcm(k+1, j, val));
//             }
//             else{
//                 int newAns = Math.max(mcm(i, k, val), mcm(k+1, j, val)) + sumt1;
//                 ans = Math.max(ans, newAns);
//             }
//         }
        
//         memo[i][j] = ans;
//         return ans;
//     }
// }


// // mcm - recursion
//
// class Solution {
//     int[] pre;
//     public int stoneGameV(int[] val) {
//         int n = val.length;
//         pre = new int[n+1];
        
//         for(int i=1; i<=n; ++i) pre[i] = pre[i-1] + val[i-1];
        
//         return mcm(0, n-1, val);
//     }
//     private int mcm(int i, int j, int[] val){
//         if(i>=j) return 0;
        
//         int sumt = pre[j+1] - pre[i];
//         int ans = 0;
//         for(int k=i; k<j; ++k){
//             int sumt1 = pre[k+1] - pre[i];
//             int sumt2 = pre[j+1] - pre[k+1];
            
//             if(sumt1 < sumt2){
//                 ans = Math.max(ans, sumt1 + mcm(i, k, val));
//             }
//             else if(sumt1 > sumt2){
//                 ans = Math.max(ans, sumt2 + mcm(k+1, j, val));
//             }
//             else{
//                 int newAns = Math.max(mcm(i, k, val), mcm(k+1, j, val)) + sumt1;
//                 ans = Math.max(ans, newAns);
//             }
//         }
        
//         return ans;
//     }
// }