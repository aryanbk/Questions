class Solution {
    public int noOf1(int n) {
        int ans=0;
        while(n != 0){
            ans += 1;
            n &= (n-1);
        }
        return ans;
    }
    //
    //
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for(int i=1; i<=n; ++i) ans[i] = noOf1(i);
        return ans;
    }
}