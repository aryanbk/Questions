class Solution {
    int[] memo;
    public int numDecodings(String s) {
        memo = new int[s.length() + 1];
        Arrays.fill(memo, -1);
        return help(s.length(), s);
    }
    int help(int i, String s){
        if(i==0)
            return 1;
        
        if(memo[i] != -1) return memo[i];
        
        int ans = s.charAt(i-1) != '0' ? help(i-1, s) : 0;
        ans += i>1 && s.charAt(i-2) != '0' && Integer.parseInt(s.substring(i-2, i)) < 27 ?
            help(i-2, s) : 0;
        
        memo[i] = ans;
        return ans;
    }
}