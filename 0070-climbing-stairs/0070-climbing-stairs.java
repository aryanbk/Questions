class Solution {
    public int climbStairs(int n) {
        int prev = 1;
        int cur = 1;
        for(int i=2; i<=n; ++i){
            int temp = cur;
            cur = prev + cur;
            prev = temp;
        }
        return cur;
    }
}


// class Solution {
//     public int climbStairs(int n) {
//         int[] dp = new int[n+1];
//         dp[0] = dp[1] = 1;
//         for(int i=2; i<=n; i++){
//             dp[i] = dp[i-1] + dp[i-2];
//         }
//         return dp[n];
//     }
// }


// class Solution {
//     public int climbStairs(int n) {
//         return climb(n);
//     }
//     private int climb(int n){
//         if(n < 0) return 0;
//         if(n == 0) return 1;
//         return climb(n-1) + climb(n-2);
//     }
// }