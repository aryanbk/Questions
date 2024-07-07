class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int empty = 0;
        int ans = 0;
        
        while(numBottles!=0){
            ans += numBottles;
            empty += numBottles;
            numBottles = (empty)/numExchange;
            empty = (empty)%numExchange;
        }
        
        return ans;
    }
}



// class Solution {
//     public int numWaterBottles(int numBottles, int numExchange) {
//         return solve(numBottles, 0, numExchange);
//     }
    
//     int solve(int filled, int empty, int rate){
//         if(filled==0 && empty<rate) return 0;
//         return filled + solve((filled+empty)/rate, (filled+empty)%rate, rate);
//     }
// }