class Solution {
    Integer[][][] cache;
    public int countDigitOne(int n) {
        String str = Integer.toString(n);
        cache = new Integer[str.length()][2][10];
        return dp(0, 0, 0, str);
    }
    int dp(int i, int allow, int tot, String n){
        if(i==n.length()) return tot;
        if(cache[i][allow][tot] != null) return cache[i][allow][tot];
        
        int limit = allow==1 ? 9 : n.charAt(i) - '0';
        int ans = 0;
        
        for(int x=0; x<=limit; ++x){
            int newAllow = (allow == 1 || x<limit) ? 1 : 0;
            int newTot = tot + (x==1 ? 1 : 0);
            ans += dp(i+1, newAllow, newTot, n);
        }
        cache[i][allow][tot] = ans;
        return ans;
    }
}


// // I forgot the tot variable in cache
//
// class Solution {
//     Integer[][] cache;
//     public int countDigitOne(int n) {
//         cache = new Integer[n+1][2];
//         return dp(0, 0, 0, Integer.toString(n));
//     }
//     int dp(int i, int allow, int tot, String n){
//         if(i==n.length()) return tot;
//         if(cache[i][allow] != null) return cache[i][allow];

//         int limit = allow==1 ? 9 : n.charAt(i) - '0';
//         int ans = 0;
        
//         for(int x=0; x<=limit; ++x){
//             int newAllow = (allow == 1 || x<limit) ? 1 : 0;
//             int newTot = tot + (x==1 ? 1 : 0);
//             ans += dp(i+1, newAllow, newTot, n);
//         }
//         cache[i][allow] = ans;
//         return ans;
//     }
// }