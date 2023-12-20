class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int[][] dp = new int[n][1001]; // diff can be negative, so will add 500 to diff
        
        for(int i=0; i<n; ++i){
            for(int j=0; j<i; ++j){
                
                int diff = nums[i] - nums[j] + 500;
                dp[i][diff] = Math.max(dp[i][diff], dp[j][diff]+1);
                ans = Math.max(ans, dp[i][diff]);
                
            }
        }
        
        return ans+1;
    }
}


// // first attempt
//
// class Solution {
//     public int longestArithSeqLength(int[] nums) {
//         int n = nums.length;
//         int ans = 0;
//         // Arrays.sort(nums); // dont do it WA #1
//         System.out.println(Arrays.toString(nums));
//         int[][] dp = new int[n][1002]; // diff can be negative
        
//         for(int i=0; i<n; ++i){
//             for(int j=0; j<i; ++j){
//                 int diff = nums[i]-nums[j]+500;
//                 dp[i][diff] = Math.max(dp[i][diff], dp[j][diff]+1);
//                 ans = Math.max(ans, dp[i][diff]);
//             }
//         }
        
//         return ans+1;
//     }
// }