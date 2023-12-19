class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1+1][n2+1];
        
        for(int i=0; i<=n1; ++i){
            for(int j=0; j<=n2; ++j){
                if(i==0 && j==0) continue;
                if(i==0){
                    for(int x=0; x<j; ++x) dp[i][j] += s2.charAt(x);
                    continue;
                }
                if(j==0){
                    for(int x=0; x<i; ++x) dp[i][j] += s1.charAt(x);
                    continue;
                }
                dp[i][j] = Math.min(s1.charAt(i-1)+dp[i-1][j], s2.charAt(j-1)+dp[i][j-1]);
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]);
            }
        }
        
        return dp[n1][n2];
    }
}