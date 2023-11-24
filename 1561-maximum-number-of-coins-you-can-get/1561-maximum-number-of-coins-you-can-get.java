class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int ans = 0;
        for(int i=0; i<piles.length*2/3; i+=2) ans += piles[piles.length - i - 2];
        return ans;
    }
}


// class Solution {
//     public int maxCoins(int[] piles) {
//         Arrays.sort(piles);
//         int i=0;
//         int j=piles.length-2;
//         int ans = 0;
//         while(i<=j){
//             ans += piles[j];
//             ++i;
//             j-=2;
//         }
//         return ans;
//     }
// }