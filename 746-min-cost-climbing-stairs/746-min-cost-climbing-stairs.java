class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        dp=new int[cost.length];
        return Math.min(helper(cost,0), helper(cost, 1));
    }
    int helper(int[] cost, int i){
        if(i==cost.length) return 0;
        if(dp[i]!=0) return dp[i];
        int one=helper(cost, i+1);
        int two=Integer.MAX_VALUE;
        if(i+2<=cost.length) two=helper(cost, i+2);
        dp[i]=cost[i]+Math.min(one, two);
        return dp[i];
    }
}