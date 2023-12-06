class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n+2];
        newNums[0] = newNums[n+1] = 1;
        for(int i=0; i<n; ++i) newNums[i+1] = nums[i];
        
        return mcm(0, n+1, newNums, new int[n+2][n+2]);
    }
    
    private int mcm(int i, int j, int[] nums, int[][] memo){
        if(i >= j - 1) return 0;
        if(memo[i][j] > 0) return memo[i][j];

        int maxCoins = 0;
        for(int k = i + 1; k < j; ++k){
            int left = mcm(i, k, nums, memo);
            int right = mcm(k, j, nums, memo);
            int currCoins = nums[i] * nums[k] * nums[j] + left + right;
            maxCoins = Math.max(maxCoins, currCoins);
        }

        memo[i][j] = maxCoins;
        return maxCoins;
    }
}