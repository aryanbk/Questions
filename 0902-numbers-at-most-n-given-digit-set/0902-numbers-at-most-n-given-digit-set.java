class Solution {
    Integer[][][] cache;
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String str = Integer.toString(n);
        cache = new Integer[str.length()][2][2];
        return dp(0, 0, 1, digits, str) - 1;
    }
    int dp(int i, int allow, int zero, String[] digits, String n){
        if(i==n.length()) return 1;
        if(cache[i][allow][zero] != null) return cache[i][allow][zero];
        
        int ans = zero==1 ? dp(i+1, 1, 1, digits, n) : 0;
        int end = allow==1 ? 9 : n.charAt(i)-'0';
        
        for(int x=0; x<digits.length; ++x){
            int cur = Integer.parseInt(digits[x]);
            if(cur <= end)
            ans += dp(i+1, (allow==1 || cur<end) ? 1 : 0, 0, digits, n);
        }
        
        cache[i][allow][zero] = ans;
        return ans;
    }
}