public class Solution {
    int ans = 0;
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        
        for (int i = 0; i < s.length(); i++) {
            solve(s, i, i);
            solve(s, i, i + 1);
        }
        return ans;
    }
    
    private void solve(String s, int i, int j) {
        while (i >=0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            ans++; i--; j++;
        }
    }
}