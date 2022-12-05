class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for(int i=1; i<=n; i++) ans[i] = i%2==0 ? ans[i/2] : ans[i/2]+1;
        return ans;
    }
}


// class Solution {
//     public int[] countBits(int n) {
//         int[] ans = new int[n+1];
//         int last2power=1;
//         for(int i=1; i<=n; ++i){
//             if((i&(i-1))==0) last2power=i;
//             ans[i] = 1 + ans[i-last2power];
//         }
//         return ans;
//     }
// }



// class Solution {
//     public int noOf1(int n) {
//         int ans=0;
//         while(n != 0){
//             ans += 1;
//             n &= (n-1);
//         }
//         return ans;
//     }
//     //
//     //
//     public int[] countBits(int n) {
//         int[] ans = new int[n+1];
//         for(int i=1; i<=n; ++i) ans[i] = noOf1(i);
//         return ans;
//     }
// }