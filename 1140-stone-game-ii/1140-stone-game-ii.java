class Solution {
    Map<String, Integer> memo;
    public int stoneGameII(int[] piles) {
        memo = new HashMap<>();
        int solve = solve(0, 1, 1, piles);
        int sumt = 0;
        for(int p: piles) sumt += p;
        return (sumt + solve)/2;
    }
    private int solve(int i, int m, int alice, int[] piles){
        if(i>=piles.length)
            return 0;
        
        String key = i+" "+m+" "+alice;
        if(memo.containsKey(key)) return memo.get(key);
        
        int sumt = 0;
        int ans = alice==1 ? -100000 : 100000;
        // int ans = 0;
        for(int j=i; j<i+(2*m) && j<piles.length; ++j){
            sumt += piles[j];
            if(alice==1)
                ans = Math.max(ans, sumt + solve(j+1, Math.max(m, j-i+1), 0, piles));
            else
                ans = Math.min(ans, -sumt + solve(j+1, Math.max(m, j-i+1), 1, piles));
        }
        
        // System.out.println();
        memo.put(key, ans);
        return ans;
    }
}