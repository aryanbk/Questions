class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+2];
        for(int i=n-1; i>=0; --i)
            dp[i] = Math.min(dp[i+1], dp[i+2]) + cost[i];
        
        return Math.min(dp[0], dp[1]);
    }
}




// class Solution {
//     public int minCostClimbingStairs(int[] cost) {
//         return Math.min(help(0, cost), help(1, cost));
//     }
//     int help(int i, int[] cost){
//         if(i>=cost.length) return 0;
//         return Math.min(help(i+1, cost), help(i+2, cost))+cost[i];
//     }
// }