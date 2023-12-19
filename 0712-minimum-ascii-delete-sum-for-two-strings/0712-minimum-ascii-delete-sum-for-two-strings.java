class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[] dp = new int[n2+1];
        
        for(int i=0; i<=n1; ++i){
            int[] t = new int[n2+1];
            for(int j=0; j<=n2; ++j){
                if(i==0 && j==0) continue;
                if(i==0){
                    for(int x=0; x<j; ++x) t[j] += s2.charAt(x);
                    continue;
                }
                if(j==0){
                    for(int x=0; x<i; ++x) t[j] += s1.charAt(x);
                    continue;
                }
                t[j] = Math.min(s1.charAt(i-1)+dp[j], s2.charAt(j-1)+t[j-1]);
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    t[j] = Math.min(t[j], dp[j-1]);
            }
            dp = t;
        }
        
        return dp[n2];
    }
}