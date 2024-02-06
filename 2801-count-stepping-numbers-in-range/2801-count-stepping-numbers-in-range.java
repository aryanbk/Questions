class Solution {
    int MOD = 1000000007;
    Integer[][][][] cache;
    public int countSteppingNumbers(String low, String high) {
        int diff = high.length() - low.length();
        
        low = "0".repeat(diff) + low;
        cache = new Integer[high.length()+1][11][2][2];
        
        return dp(0, 10, 0, 0, low, high);
    }
    
    int dp(int i, int prev, int allow1, int allow2, String low, String high){
        if(i==high.length()) return 1;
        if(cache[i][prev][allow1][allow2] != null) return cache[i][prev][allow1][allow2];
        
        int ans = 0;
        int start = allow1==1 ? 0 : low.charAt(i)-'0';
        int end = allow2==1 ? 9 : high.charAt(i)-'0';
        
        
        if(prev == 10){
            for(int x=start; x<=end; ++x){
                int newPrev = x!=0 ? x : 10;
                int newAllow1 = (allow1==1 || x>start) ? 1 : 0;
                int newAllow2 = (allow2==1 || x<end) ? 1 : 0;
                ans = (ans + dp(i+1, newPrev, newAllow1, newAllow2, low, high)) % MOD;
            }
            return ans;
        }
        
        int x = prev - 1;
        if(x>=start && x<=end){
            int newAllow1 = (allow1==1 || x>start) ? 1 : 0;
            int newAllow2 = (allow2==1 || x<end) ? 1 : 0;
            ans = (ans + dp(i+1, x, newAllow1, newAllow2, low, high)) % MOD;
        }
        x = prev + 1;
        if(x>=start && x<=end){
            int newAllow1 = (allow1==1 || x>start) ? 1 : 0;
            int newAllow2 = (allow2==1 || x<end) ? 1 : 0;
            ans = (ans + dp(i+1, x, newAllow1, newAllow2, low, high)) % MOD;
        }
        
        cache[i][prev][allow1][allow2] = ans;
        return ans;
    }
}