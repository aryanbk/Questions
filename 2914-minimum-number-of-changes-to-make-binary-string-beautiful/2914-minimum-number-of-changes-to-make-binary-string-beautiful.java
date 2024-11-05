class Solution {
    public int minChanges(String s) {
        int ans = 0;
        for(int i=0; i<s.length(); i+=2){
            int a = s.charAt(i)-'0';
            int b = s.charAt(i+1)-'0';
            ans += (a^b);
        }
        return ans;
    }
}