class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        
        for(int i=0; i<=n; ++i){
            if(i==0){
                dp[i][0] = 0;
                dp[i][1] = -1000000;
            }
            else{
                // dp[currLength][buy] = Math.max(hodl, buyOrSell);
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i-1]); // to sell
                
                dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i-1]); // to buy
            }
        }
        return dp[n][0]; // Maximum profit when not holding any stock after all transactions
    }
}


// DP - memo O(n*2) O(n*2)
//
//
// class Solution {
//     int[][] memo;
    
//     public int maxProfit(int[] prices) {
//         memo = new int[prices.length+1][2];
//         for(int[] row: memo) Arrays.fill(row, -1000000);
//         return find(0, 1, prices); //buy==1 means to buy and 0 means to sell
//     }
    
//     private int find(int i, int buy, int[] prices){
//         if(i==prices.length)
//             return 0;
        
//         if(memo[i][buy] != -1000000) return memo[i][buy];
        
//         int buyOrSell = find(i+1, buy^1, prices) + (prices[i] * (buy==1 ? -1 : 1));
//         int hodl = find(i+1, buy, prices);
        
//         memo[i][buy] = Math.max(buyOrSell, hodl);
        
//         return memo[i][buy];
//     }
// }


// DP - memo


// class Solution {
//     int[][] memo;
    
//     public int maxProfit(int[] prices) {
//         memo = new int[prices.length+1][2];
//         for(int[] row: memo) Arrays.fill(row, -1000000);
//         return find(0, true, prices);
//     }
    
//     private int find(int i, boolean buy, int[] prices){
//         if(i==prices.length)
//             return buy ? 0 : -100000;
        
//         int buyInt = buy ? 1 : 0;
        
//         if(memo[i][buyInt] != -1000000) return memo[i][buyInt];
        
//         int buyOrSell = find(i+1, !buy, prices) + (prices[i] * (buy ? -1 : 1));
//         int hodl = find(i+1, buy, prices);
        
//         memo[i][buyInt] = Math.max(buyOrSell, hodl);
        
//         return memo[i][buyInt];
//     }
// }



// recurssion
//
//
// class Solution {
//     public int maxProfit(int[] prices) {
//         return find(0, true, prices);
//     }
//     private int find(int i, boolean buy, int[] prices){
//         if(i==prices.length)
//             return buy ? 0 : -100000;
        
//         int buyOrSell = find(i+1, !buy, prices) + (prices[i] * (buy ? -1 : 1));
//         int hodl = find(i+1, buy, prices);
        
//         return Math.max(buyOrSell, hodl);
//     }
// }





//
// 2022
//
// class Solution {
//     public int maxProfit(int[] prices) {
//         long[] prev = new long[]{0, (long)Integer.MIN_VALUE};
//         for(int i=1; i<prices.length+1; ++i) 
//             prev = new long[]{Math.max(prev[0], prices[i-1]+prev[1]), Math.max(prev[1], -prices[i-1]+prev[0])};
//         return (int)prev[0];
//     }
// }



// class Solution {
//     public int maxProfit(int[] prices) {
//         long prof=0;
//         for(int i =1; i<prices.length; ++i){
//             if(prices[i]>prices[i-1]) prof+=prices[i]-prices[i-1];
//         }
//         return (int)prof;
//     }
// }