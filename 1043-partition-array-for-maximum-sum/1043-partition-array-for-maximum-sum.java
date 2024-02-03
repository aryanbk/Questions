// class Solution {
//     public int maxSumAfterPartitioning(int[] arr, int k) {
//         int n = arr.length;
//         int[] dp = new int[n + 1]; // Updated to 1D dp array
        
//         for (int i = 1; i <= n; ++i) {
//             int maxVal = 0;
//             for (int j = 1; j <= k && i - j >= 0; ++j) {
//                 maxVal = Math.max(maxVal, arr[i - j]); // Update the maximum value for the current partition
//                 dp[i] = Math.max(dp[i], dp[i - j] + maxVal * j);
//             }
//         }
        
//         return dp[n];
//     }
// }
// 
// not tried above code





class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        
        for(int i=n-1; i>=0; --i){
            for(int j=i; j<n; ++j){
                if(i==j) dp[i][j] = arr[i];
                else{
                    int mx = 0;
                    for(int p=i; p<k+i && p<=j; ++p){
                        mx = Math.max(mx, arr[p]);
                        int currSum = (p-i+1)*mx; // IMP
                        int nxSum = p>=j ? 0 : dp[p+1][j]; // IMP 
                        // above steps are not req. in recurssion but it's imp here
                        dp[i][j] = Math.max(dp[i][j], currSum + nxSum);
                    }
                }
            }
        }
        
        return dp[0][n-1];
    }
}


// // DP - Memo
//
// class Solution {
//     public int maxSumAfterPartitioning(int[] arr, int k) {
//         return mcm(0, arr.length-1, arr, k, new Integer[arr.length][arr.length]);
//     }
//     private int mcm(int i, int j, int[] arr, int k, Integer[][] memo){
//         if(i>j) return 0;
//         if(i==j) return arr[i];
//         if(memo[i][j] != null) return memo[i][j];
//         memo[i][j] = 0;
//         int mx = 0;
//         for(int p=i; p<k+i && p<=j; ++p){
//             mx = Math.max(mx, arr[p]);
//             memo[i][j] = Math.max(memo[i][j], ((p-i+1)*mx) + mcm(p+1, j, arr, k, memo));
//         }
//         return memo[i][j];
//     }
// }