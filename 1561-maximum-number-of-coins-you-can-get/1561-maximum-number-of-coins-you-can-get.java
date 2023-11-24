class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int i=0;
        int j=piles.length-2;
        int ans = 0;
        while(i<=j){
            ans += piles[j];
            ++i;
            j-=2;
        }
        return ans;
    }
}