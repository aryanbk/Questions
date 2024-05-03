class Solution {
    Integer[][] dp;
    int n;
    int[] sumt;
    public int splitArray(int[] nums, int k) {
        n = nums.length;
        dp = new Integer[n+1][k+1];
        sumt = new int[n+1];
        
        for(int i=0; i<n; ++i) sumt[i+1] = sumt[i]+nums[i];
        
        return solve(0, nums, k);
    }
    
    int solve(int i, int[] nums, int k){
        if(k==1){
            dp[i][k] = sumt[n]-sumt[i];
            return dp[i][k];
        }
        
        if(dp[i][k] != null) return dp[i][k];
        
        int ans = 1000000000;
        
        int lo = i;
        int hi = nums.length-k+1;
        
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            int res = solve(mid+1, nums, k-1);
            int cur = sumt[mid+1] - sumt[i];
            if(cur > res) hi = mid-1;
            else if(cur < res) lo = mid + 1;
            ans = Math.min(ans, Math.max(cur, res));
            if(cur==res) break;
        }
        
        dp[i][k] = ans;
        return ans;
    }
}








// class Solution {
//     Integer[][] dp;
//     public int splitArray(int[] nums, int k) {
//         int ans = Integer.MAX_VALUE;
//         dp = new Integer[nums.length+1][k+1];
//         return solve(0, nums, k);
//     }
//     int solve(int i, int[] nums, int k){
//         if(k==1){
//             int ans = 0;
//             for(int j=i; j<nums.length; ++j) ans += nums[j];
//             dp[i][k] = ans;
//             return ans;
//         }
//         if(dp[i][k] != null) return dp[i][k];
//         int cur = 0;
//         int ans = 1000000000;
//         for(int j=i; j<=nums.length-k+1; ++j){
//             cur += nums[j];
//             int mxSum = Math.max(cur, solve(j+1, nums, k-1));
//             ans = Math.min(ans, mxSum);
//         }
//         dp[i][k] = ans;
//         return ans;
//     }
// }