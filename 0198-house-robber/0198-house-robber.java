// class Solution {
//     public int rob(int[] nums) {
//         int last=0,secLast=0;
//         for(int i: nums){
//             int temp=Math.max(i+secLast, last);
//             secLast=last;
//             last=temp;
//         }
//         return last;
//     }
// }




class Solution {
    Integer[] dp;
    public int rob(int[] nums) {
        dp = new Integer[nums.length+1];
        return solve(0, nums);
    }
    int solve(int i, int[] nums){
        if(i>=nums.length) return 0;
        if(dp[i] == null)
            dp[i] = Math.max(solve(i+1, nums), nums[i] + solve(i+2, nums));
        return dp[i];
    }
}




// // wont work
// // testcase [2,1,1,2]
//
// class Solution {
//     public int rob(int[] nums) {
//         int last=0,secLast=0;
//         for(int i: nums){
//             secLast += i;
//             int swap = last;
//             last = secLast;
//             secLast = swap;
//         }
//         return Math.max(last, secLast);
//     }
// }
