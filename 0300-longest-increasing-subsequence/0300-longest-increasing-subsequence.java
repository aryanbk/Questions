// tabulation (instead of starting j at 0, start j from i)
// 1D array
// 
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[]dp = new int[n+1];
        
        for(int i=1; i<n+1; ++i){
            int[] newDp = new int[n+1];
            for(int j=i; j<n+1; ++j){
                newDp[j] = dp[j];
                if(j==n || nums[i-1] < nums[j])
                    newDp[j] = Math.max(newDp[j], 1+dp[i-1]);
            }
            dp = newDp;
        }
        
        return dp[n];
    }
}


// tabulation
// 1D array
// 
// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;
//         int[]dp = new int[n+1];
        
//         for(int i=1; i<n+1; ++i){
//             int[] newDp = new int[n+1];
//             for(int j=0; j<n+1; ++j){
//                 newDp[j] = dp[j];
//                 if(j==n || nums[i-1] < nums[j])
//                     newDp[j] = Math.max(newDp[j], 1+dp[i-1]);
//             }
//             dp = newDp;
//         }
        
//         return dp[n];
//     }
// }



// tabulation
// 2D array
//
// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;
//         int[][] dp = new int[n+1][n+1];
        
//         for(int i=1; i<n+1; ++i){
//             for(int j=0; j<n+1; ++j){
//                 dp[i][j] = dp[i-1][j];
//                 if(j==n || nums[i-1] < nums[j])
//                     dp[i][j] = Math.max(dp[i][j], 1+dp[i-1][i-1]);
//             }
//         }
        
//         return dp[n][n];
//     }
// }

// i == length of array
// j == index of element from which last element of subseq should be lesser
// if j==n take it as +inf and consider all current element are smaller than this



// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         return find(nums.length, 100000, nums);
//     }
//     private int find(int l, int last, int[] nums){
//         if(l==0) return 0;
//         int ans = find(l-1, last, nums);
//         if(nums[l-1] < last)
//             ans = Math.max(ans, 1 + find(l-1, nums[l-1], nums));
//         return ans;
//     }
// }