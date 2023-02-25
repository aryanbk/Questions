class Solution {
    public int maxProfit(int[] prices) {
        int mini=prices[0], profit=0;
        for(int i: prices){
            mini=Math.min(mini, i);
            profit=Math.max(profit, i-mini);
        }
        return profit;
    }
}

// class Solution {
//     public int maxProfit(int[] prices) {
//         int l=0, profit=0;
//         for(int r=0; r<prices.length; r++){
//             profit=Math.max(profit, prices[r]-prices[l]);
//             if(prices[r]<prices[l]) l=r;
//         }
//         return profit;
//     }
// }