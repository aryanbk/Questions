class Solution {
    int[][] dp;
    int t;
    public int findTargetSumWays(int[] nums, int target) {
        dp= new int[nums.length+1][2001];
        for(int[] row : dp) Arrays.fill(row, -1);
        t=target;
        return subsetsum(nums, nums.length, 0);
    }
    
    int subsetsum(int[] nums, int lnt, int trgt){
        if(lnt==0){
            if(trgt==t) return 1;
            else return 0;
        }
        if(dp[lnt][trgt+1000]!=-1) return dp[lnt][trgt+1000];
        dp[lnt][trgt+1000] = subsetsum(nums, lnt-1, trgt+nums[lnt-1]) + subsetsum(nums, lnt-1, trgt-nums[lnt-1]);
        return dp[lnt][trgt+1000];
    }
}

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