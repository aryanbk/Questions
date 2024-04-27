class Solution {
    Integer[][] dp;
    int n;
    public int findRotateSteps(String ring, String key) {
        n = ring.length();
        dp = new Integer[n][key.length()];
       return solve(0, 0, ring, key); 
    }
    int solve(int r, int k, String ring, String key){
        // System.out.println(r+" "+k);
        if(k == key.length()) return 0;
        
        if(ring.charAt(r) == key.charAt(k))
            return solve(r, k+1, ring, key)+1;
        
        if(dp[r][k] != null) return dp[r][k];
        
        int i = r;
        int step = 0;
        while(ring.charAt(i) != key.charAt(k)){
            i = (i+1)%n;
            ++step;
        }
        
        int j = r;
        int step2 = 0;
        while(ring.charAt(j) != key.charAt(k)){
            j = (j+n-1)%n;
            ++step2;
        }
        
        int ans = Math.min(solve(i, k, ring, key)+step, 
                       solve(j, k, ring, key)+step2);
        
        dp[r][k] = ans;
        
        return ans;
        
        // return Math.min(solve((r+1)%n, k, ring, key),
                       // solve((r+n-1)%n, k, ring, key)) + 1;
    }
}