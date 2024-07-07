class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        return solve(numBottles, numExchange, 0);
    }
    
    int solve(int filled, int exch, int empty){
        if(filled==0 && empty<exch) return 0;
        return filled + solve((filled+empty)/exch, exch, (filled+empty)%exch);
    }
}