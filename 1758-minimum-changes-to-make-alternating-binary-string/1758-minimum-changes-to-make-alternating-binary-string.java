class Solution {
    public int minOperations(String s) {
        boolean x = s.charAt(0) == '1';
        int ans = 0;
        for(int i=0; i<s.length(); ++i, x=!x)
            ans += x ^ s.charAt(i) == '1' ? 1 : 0;
        return Math.min(ans, s.length() - ans);
    }
}