class Solution {
    public int maxScore(String s) {
        int ones = 0;
        int n = s.length();
        int zeros = 0;
        int ans = 0;
        
        for(int i=0; i<n; ++i) ones += s.charAt(i)=='1' ? 1 : 0;
        
        for(int i=0; i<n-1; ++i){
            if(s.charAt(i)=='0') ++zeros;
            else --ones;
            ans = Math.max(ans, zeros+ones);
        }
        
        return ans;
    }
}