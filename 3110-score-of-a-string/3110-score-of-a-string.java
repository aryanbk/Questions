class Solution {
    public int scoreOfString(String s) {
        int ans = 0;
        char prev = s.charAt(0);
        for(int i=0; i<s.length(); ++i){
            ans += Math.abs(prev - s.charAt(i));
            prev = s.charAt(i);
        }
        return ans;
    }
}