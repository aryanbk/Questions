class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n+2];
        newNums[0] = newNums[n+1] = 1;
        for(int i=0; i<n; ++i) newNums[i+1] = nums[i];
        
        int[][] dp = new int[n+2][n+2];
        
        for(int i=n+1; i>=0; --i){
            for(int j=i+2; j<=n+1; ++j){
                for(int k=i+1; k<j; ++k){
                    dp[i][j] = Math.max(dp[i][j], newNums[i]*newNums[k]*newNums[j] + dp[i][k] + dp[k][j]);
                }
            }
        }
        
        return dp[0][n+1];
    }
}


// // DP - memo
// //
// class Solution {
//     public int maxCoins(int[] nums) {
//         int n = nums.length;
//         int[] newNums = new int[n+2];
//         newNums[0] = newNums[n+1] = 1;
//         for(int i=0; i<n; ++i) newNums[i+1] = nums[i];
        
//         return mcm(0, n+1, newNums, new int[n+2][n+2]);
//     }
    
//     private int mcm(int i, int j, int[] nums, int[][] memo){
//         if(i >= j - 1) return 0;
//         if(memo[i][j] > 0) return memo[i][j];

//         int maxCoins = 0;
//         for(int k = i + 1; k < j; ++k){
//             int left = mcm(i, k, nums, memo);
//             int right = mcm(k, j, nums, memo);
//             int currCoins = nums[i] * nums[k] * nums[j] + left + right;
//             maxCoins = Math.max(maxCoins, currCoins);
//         }

//         memo[i][j] = maxCoins;
//         return maxCoins;
//     }
// }