class Solution {
    int[][] memo;
    public int coinChange(int[] coins, int amount) {
        memo = new int[coins.length+1][amount+1];
        for(int[] m1: memo) Arrays.fill(m1, -1);
        
        help(coins.length, coins, amount);
        return memo[coins.length][amount]>10000 ? -1 : memo[coins.length][amount];
    }
    private int help(int l, int[] coins, int amt){
        if(l==0) return amt==0? 0: 100001;
        if(memo[l][amt] != -1) return memo[l][amt];
        memo[l][amt] = help(l-1, coins, amt) ;
        if(amt>=coins[l-1]) memo[l][amt] = Math.min(memo[l][amt], 1 + help(l, coins, amt-coins[l-1]));
        return memo[l][amt];
    }
}