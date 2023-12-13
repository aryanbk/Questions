// // Tabulation - Space optimized
// // O(n*3)
// // O(1)
//
class Solution {
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int[] dp = new int[]{0, -1000000000, -1000000000};
        
        for(int i=1; i<n+1; ++i){
            int[] newDp = new int[3];
            for(int j=0; j<3; ++j){
                newDp[j] = Math.max(dp[j], nums[i-1] + dp[(j+nums[i-1])%3]);
            }
            dp = newDp;
        }
        
        return dp[0];
    }
}


// // Tabulation
// // O(n*3)
// // O(n*3)
//
// class Solution {
//     public int maxSumDivThree(int[] nums) {
//         int n = nums.length;
//         int[][] dp = new int[n+1][3];
//         dp[0] = new int[]{0, -1000000000, -1000000000};
        
//         for(int i=1; i<n+1; ++i){
//             for(int j=0; j<3; ++j){
//                 dp[i][j] = Math.max(dp[i-1][j], nums[i-1] + dp[i-1][(j+nums[i-1])%3]);
//             }
//         }
        
//         return dp[n][0];
//     }
// }


// // Memo
// // O(n*3)
// // O(n*3)
//
// class Solution {
//     int[][] memo;
//     public int maxSumDivThree(int[] nums) {
//         memo = new int[nums.length+1][3];
//         for(int[] row: memo) Arrays.fill(row, -1);
//         return help(nums.length, 0,nums);
//     }
//     private int help(int i, int remainder, int[] nums){
//         if(i==0)
//             return remainder==0 ? 0 : -100000000;
        
//         if(memo[i][remainder] != -1) return memo[i][remainder];
        
//         memo[i][remainder] = Math.max(help(i-1, remainder, nums), 
//                                       nums[i-1]+help(i-1, (remainder+nums[i-1])%3, nums));
//         return memo[i][remainder];
//     }
// }


// // memo 
// // O(n*sumt(n))
// // TLE, MLE
// //
// class Solution {
//     Map<List<Integer>, Integer> map;
//     public int maxSumDivThree(int[] nums) {
//         map = new HashMap<>();
//         return help(nums.length, 0,nums);
//     }
//     private int help(int i, int sumt, int[] nums){
//         if(i==0)
//             return sumt%3==0 ? sumt : 0;
//         List<Integer> list = List.of(i, sumt);
//         if(map.containsKey(list)) return map.get(list);
        
//         map.put(list, Math.max(help(i-1, sumt, nums), help(i-1, sumt+nums[i-1], nums)));
//         return map.get(list);
//     }
// }

// // recursion O(2^n) TLE
//
// class Solution {
//     public int maxSumDivThree(int[] nums) {
//         return help(nums.length, 0,nums);
//     }
//     private int help(int i, int sumt, int[] nums){
//         if(i==0)
//             return sumt%3==0 ? sumt : 0;
//         return Math.max(help(i-1, sumt, nums), help(i-1, sumt+nums[i-1], nums));
//     }
// }