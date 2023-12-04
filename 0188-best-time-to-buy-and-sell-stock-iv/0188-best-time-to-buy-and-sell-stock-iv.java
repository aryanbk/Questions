class Solution {
    Integer[][][] memo;
    
    public int maxProfit(int k, int[] prices) {
        memo = new Integer[prices.length+1][2][k+1];
        
        return find(0, 1, k, prices); //buy==1 means to buy and 0 means to sell
    }
    
    private int find(int i, int buy, int k, int[] prices){
        if(i==prices.length || k==0)
            return 0;
        if(memo[i][buy][k] != null) return memo[i][buy][k];
        
        int buyOrSell = 0;
        if(buy==1)
            buyOrSell = find(i+1, 0, k, prices) - prices[i];
        else
            buyOrSell = find(i+1, 1, k-1, prices) + prices[i];

        
        int hodl = find(i+1, buy, k, prices);
        
        memo[i][buy][k] = Math.max(buyOrSell, hodl);
        
        return memo[i][buy][k];
    }
}