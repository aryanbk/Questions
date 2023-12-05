class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int[] increasing = LIS(nums);
        int[] decreasing = LDS(nums);
        int n = nums.length;
        int ans = 0;
        
        for (int i = 1; i < n - 1; ++i) {
            if (increasing[i] > 1 && decreasing[i] > 1) {
                ans = Math.max(ans, increasing[i] + decreasing[i] - 1);
            }
        }
        
        return n - ans;
        
        // this will give error
        // it will check longest mountain in i=0 and i=n-1 also
        // then it will not be mountain
        // testcase = [9,8,1,7,6,5,4,3,2,1] o/p = 1 expected = 2
        //
        // for(int i=0; i<n; ++i)
        //     ans = Math.max(ans, increasing[i]+decreasing[i]-1);
        // return n-ans;
    }
    
    public int[] LIS(int[] nums) {
        int n = nums.length;
        int[]dp = new int[n];
        Arrays.fill(dp, 1);
        
        for(int i=0; i<n; ++i){
            for(int j=0; j<i; ++j){
                if(nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }
        
        return dp;
    }
    public int[] LDS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = n-1; i>=0 ; --i) {
            for (int j = n-1; j>i; --j) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return dp;
    }
}