class Solution {
    public int getLucky(String s, int k) {
        int ans = 0;
        for(int i=0; i<s.length(); ++i){
            ans += getSum(s.charAt(i)-'a'+1);
        }
        for(; k>1; --k) ans = getSum(ans);
        return ans;
    }
    int getSum(int i){
        // if(i<10) return i;
        int ans = 0;
        for(; i>0; i/=10) ans += i%10;
        return ans;
    }
}