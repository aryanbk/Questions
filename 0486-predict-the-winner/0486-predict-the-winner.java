class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        if(n%2==0 || n==1) return true; // WA #3
        
        int[][] dp = new int[n][n];
        
        for(int i=n-1; i>=0; --i){
            for(int j=i; j<n; ++j){
                dp[i][j] = -1000000000; // WA #2
                if(i<n-1) dp[i][j] = Math.max(dp[i][j], nums[i]-dp[i+1][j]);
                if(j>0) dp[i][j] = Math.max(dp[i][j], nums[j]-dp[i][j-1]);
            }
        }
        return dp[0][n-1] >= 0;
    }
}

// // memo
//
// class Solution {
//     Integer[][] memo;
//     public boolean predictTheWinner(int[] nums) {
//         int n = nums.length;
//         memo = new Integer[n][n];
//         return n%2==0 ? true : help(0, n-1, nums)>=0;
//     }
//     private int help(int i, int j, int[] nums){
//         if(i>j)
//             return 0;
//         if(memo[i][j] == null) 
//             memo[i][j] = Math.max(nums[i] - help(i+1, j, nums), nums[j] - help(i, j-1, nums));
//         return memo[i][j];
//     }
// }


// // recurence
//
// class Solution {
//     int n;
//     public boolean predictTheWinner(int[] nums) {
//         n = nums.length;
//         return n%2==0 ? true : help(0, n-1, nums)>=0;
//     }
//     private int help(int i, int j, int[] nums){
//         if(i>j)
//             return 0;
//         return Math.max(nums[i] - help(i+1, j, nums), nums[j] - help(i, j-1, nums));
//     }
// }


// // wont work WA #1
//
// class Solution {
//     public boolean predictTheWinner(int[] nums) {
//         if(nums.length%2==0) return true;
//         int even = 0;
//         for(int i=0; i<nums.length; ++i)
//             even += i%2==0 ? nums[i] : -1*nums[i];
//         return even>=0;
//     }
// }