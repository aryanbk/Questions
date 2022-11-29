class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sumt=0;
        for(int x: nums) sumt+=x;
        if(Math.abs(target)>sumt) return 0;
        int[][] dp = new int[nums.length+1][(2*sumt) + 1];
        
        for(int l=0; l<nums.length+1; ++l){
            for(int t=0; t<dp[0].length; ++t){
                if(l==0)
                    dp[l][t] = t==sumt ? 1 : 0;
                else{
                    if(t-nums[l-1]>=0) dp[l][t] += dp[l-1][t-nums[l-1]];
                    if(t+nums[l-1]<dp[0].length) dp[l][t] += dp[l-1][t+nums[l-1]];
                }
            }
        }
        
        return dp[nums.length][target+sumt];
    }
}


// class Solution {
//     int[][] dp;
//     int t;
//     public int findTargetSumWays(int[] nums, int target) {
//         dp= new int[nums.length+1][2001];
//         for(int[] row : dp) Arrays.fill(row, -1);
//         t=target;
//         return subsetsum(nums, nums.length, 0);
//     }
    
//     int subsetsum(int[] nums, int lnt, int trgt){
//         if(lnt==0){
//             if(trgt==t) return 1;
//             else return 0;
//         }
//         if(dp[lnt][trgt+1000]!=-1) return dp[lnt][trgt+1000];
//         dp[lnt][trgt+1000] = subsetsum(nums, lnt-1, trgt+nums[lnt-1]) + subsetsum(nums, lnt-1, trgt-nums[lnt-1]);
//         return dp[lnt][trgt+1000];
//     }
// }

// class Solution {
//     public int findTargetSumWays(int[] nums, int target) {
//         return subsetsum(nums, nums.length, 0, target);
//     }
//     int subsetsum(int[] nums, int lnt, int curr, int trgt){
//         if(lnt==0){
//             if(trgt==curr) return 1;
//             else return 0;
//         }
//         return subsetsum(nums, lnt-1, curr+nums[lnt-1]) + subsetsum(nums, lnt-1, curr-nums[lnt-1]);
//     }
// }