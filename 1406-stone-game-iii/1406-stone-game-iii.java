class Solution {
    
    int[] memo;
    public String stoneGameIII(int[] val) {
        memo = new int[val.length];
        Arrays.fill(memo, -1);
        int diff = solve(0, val);
        return diff>0 ? "Alice" : (diff<0 ? "Bob" : "Tie");
    }
    
    private int solve(int i, int[] piles){
        if(i>=piles.length)
            return 0;
        
        if(memo[i] != -1) return memo[i];
        
        int sumt = 0;
        int ans = -1000000;
        
        for(int j=i; j<i+3 && j<piles.length; ++j){
            sumt += piles[j];
            ans = Math.max(ans, sumt - solve(j+1, piles));
        }
        
        memo[i] = ans;
        return ans;
    }
}