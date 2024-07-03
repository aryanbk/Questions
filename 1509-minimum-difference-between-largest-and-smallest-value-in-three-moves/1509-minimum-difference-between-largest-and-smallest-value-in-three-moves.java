class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if(n<5) return 0;
        Arrays.sort(nums);
        
        long ans = Integer.MAX_VALUE;
        for(int i=0; i<4; ++i){
            long diff = (long)nums[i+n-4] - (long)nums[i];
            ans = Math.min(ans, diff);
        }
        return (int)ans;
    }
}





// // memory limit exceeded
//
// class Solution {
//     Integer[][] dp;
//     public int minDifference(int[] nums) {
//         Arrays.sort(nums);
//         dp = new Integer[nums.length+1][nums.length+1];
//         return solve(0, 0, nums.length-1, nums);
//     }
    
//     // only 3 moves so dp is not required
//     // x is dependant on i & j, x is not a state, i used it for convenience
//     // i & j are only state
    
//     int solve(int x, int i, int j, int[] nums){
//         if(j<i) return 0;
//         if(x==3) return nums[j]-nums[i];
//         if(dp[i][j] != null) return dp[i][j];
//         return Math.min(solve(x+1, i+1, j, nums), solve(x+1, i, j-1, nums));
//     }
// }





// class Solution {
//     public int minDifference(int[] nums) {
//         Arrays.sort(nums);
//         return solve(0, 0, nums.length-1, nums);
//     }
    
//     // only 3 moves so dp is not required
//     // x is dependant on i & j, x is not a state, i used it for convenience
//     // i & j are only state
    
//     int solve(int x, int i, int j, int[] nums){
//         if(x==3) return j>i ? nums[j]-nums[i] : 0;
//         return Math.min(solve(x+1, i+1, j, nums), solve(x+1, i, j-1, nums));
//     }
// }