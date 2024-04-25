class Solution {
    Integer[][] memo;
    public int longestIdealString(String s, int k) {
        memo = new Integer[s.length()+1][27];
        return solve(0, s, k, 26);
    }
    int solve(int i, String s, int k, int prev){
        if(i==s.length()) return 0;
        
        if(memo[i][prev] != null) return memo[i][prev];
        
        char ch = (char)(prev+'a');
        int ans = 0;
        if(prev==26 || Math.abs(s.charAt(i) - ch) <=k)
            ans = Math.max(ans, solve(i+1, s, k, s.charAt(i)-'a')) + 1;
        ans = Math.max(ans, solve(i+1, s, k, prev));
        
        memo[i][prev] = ans;
        
        return ans;
    }
}