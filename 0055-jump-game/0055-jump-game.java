class Solution {
    public boolean canJump(int[] nums) {
        int mx = 0;
        for(int i=0; i<nums.length && mx >= i; ++i)
            mx = Math.max(mx, i + nums[i]);
        return mx >= nums.length-1;
    }
}



// class Solution {
//     Boolean[] dp;
//     public boolean canJump(int[] nums) {
//         dp = new Boolean[nums.length];
//         return solve(0, nums);
//     }
    
//     boolean solve(int i, int[] nums){
//         if(i>=nums.length-1) return i==nums.length-1;
//         if(dp[i] != null) return dp[i];
//         boolean ans = false;
//         for(int j=i+1; j<Math.min(nums.length, i+nums[i]+1); ++j)
//             ans |= solve(j, nums);
//         dp[i] = ans;
//         return ans;
//     }
// }