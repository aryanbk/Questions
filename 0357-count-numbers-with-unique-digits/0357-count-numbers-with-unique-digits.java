class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int prev = 1;
        for(int i=1; i<=n; ++i){
            int ans = 9;
            for(int x=0; x<i-1; ++x) ans *= (9-x);
            prev += ans;
        }
        return prev;
    }
}


// // DP - memo
//
// class Solution {
//     public int countNumbersWithUniqueDigits(int n) {
//         if(n==0)
//             return 1;
        
//         int ans = 9;
//         for(int i=0; i<n-1; ++i)
//             ans *= (9-i);
        
//         return ans + countNumbersWithUniqueDigits(n-1);
//     }
// }