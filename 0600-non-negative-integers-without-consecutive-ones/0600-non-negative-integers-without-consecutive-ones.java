class Solution {
    Integer[][][] cache;
    public int findIntegers(int n) {
        String str = Integer.toBinaryString(n);
        cache = new Integer[str.length()+1][2][2];
        return dp(0, 1, 0, str);
    }
    int dp(int i, int one, int allow, String str){
        if(i ==  str.length()) return 1;
        if(cache[i][one][allow] != null) return cache[i][one][allow];
        
        int limit = allow==1 ? 1 : str.charAt(i)-'0';
        int ans = 0;
        
        for(int x=0; x<=limit; ++x){
            if(x==1 && !(one==1)) continue;
            int newAllow = (allow==1 || x<limit) ? 1 : 0;
            int newOne = (x!=1) ? 1 : 0;
            ans += dp(i+1, newOne, newAllow, str);
        }
        cache[i][one][allow] = ans;
        return ans;
    }
}




// // same problem without binary
// // https://leetcode.com/problems/numbers-with-repeated-digits/
//
// class Solution {
//     public int findIntegers(int n) {
//         return dp(0, 1, 0, Integer.toString(n));
//     }
//     int dp(int i, int one, int allow, String str){
//         if(i ==  str.length()) return 1;
//         int limit = allow==1 ? 9 : str.charAt(i)-'0';
//         int ans = 0;
        
//         for(int x=0; x<=limit; ++x){
//             if(x==1 && !(one==1)) continue;
//             int newAllow = (allow==1 || x<limit) ? 1 : 0;
//             int newOne = (x!=1) ? 1 : 0;
//             ans += dp(i+1, newOne, newAllow, str);
//         }
        
//         return ans;
//     }
// }