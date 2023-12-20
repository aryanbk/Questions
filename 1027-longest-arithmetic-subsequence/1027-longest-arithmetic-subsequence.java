class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int ans = 0;
        
        Map<Integer, Integer>[] dp = new HashMap[n];
        for (int i = 0; i < n; ++i) dp[i] = new HashMap<>();
        
        for(int i=0; i<n; ++i){
            for(int j=0; j<i; ++j){
                int diff = nums[i] - nums[j];
                
                dp[i].put(diff, Math.max(dp[i].getOrDefault(diff, 0), 
                                        dp[j].getOrDefault(diff, 0)+1));
                ans = Math.max(ans, dp[i].get(diff));
            }
        }
        
        return ans+1;
    }
}


// // using 2d array
//
// class Solution {
//     public int longestArithSeqLength(int[] nums) {
//         int n = nums.length;
//         int ans = 0;
//         int[][] dp = new int[n][1001]; // diff can be negative, so will add 500 to diff
        
//         for(int i=0; i<n; ++i){
//             for(int j=0; j<i; ++j){
                
//                 int diff = nums[i] - nums[j] + 500;
//                 dp[i][diff] = Math.max(dp[i][diff], dp[j][diff]+1);
//                 ans = Math.max(ans, dp[i][diff]);
                
//             }
//         }
        
//         return ans+1;
//     }
// }


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