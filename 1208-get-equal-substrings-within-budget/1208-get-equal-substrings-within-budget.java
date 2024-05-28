class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int cur = 0;
        int ans = 0;
        
        for(int l=0, r=0; r<n; ++r){
            cur += Math.abs(s.charAt(r) - t.charAt(r));
            while(cur > maxCost && l<=r){
                cur -= Math.abs(s.charAt(l) - t.charAt(l));
                ++l;
            }
            ans = Math.max(ans, r-l+1);
        }
        return ans;
    }
}








// class Solution {
//     public int equalSubstring(String s, String t, int maxCost) {
//         int n = s.length();
//         int[][] dp = new int[n+1][maxCost+1];
        
//         for(int i=1; i<=n; ++i){
//             for(int j=0; j<=maxCost; ++j){
//                 int diff = Math.abs(s.charAt(i-1) - t.charAt(i-1));
//                 dp[i][j] = dp[i-1][j];
//                 if(diff <= j) dp[i][j] = Math.max(dp[i][j], dp[i-1][j-diff] + 1);
//             }
//         }
        
//         // for(int[]d: dp)
//             // System.out.println(Arrays.toString(d));
        
//         return dp[n][maxCost];
        
//     }
// }