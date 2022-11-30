class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int ln1=text1.length(), ln2=text2.length();
        int[] prev = new int[ln2+1];
        
        for(int l1=1; l1<=ln1; ++l1){
            int[] dp = new int[ln2+1];
            for(int l2=1; l2<=ln2; ++l2){
                dp[l2] = text1.charAt(l1-1) == text2.charAt(l2-1) ? prev[l2-1]+1 : Math.max(prev[l2], dp[l2-1]);
            }
            prev = dp;
        }
        
        return prev[ln2];
    }
}



// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//         int ln1=text1.length(), ln2=text2.length();
//         int[][] dp = new int[ln1+1][ln2+1];
        
//         for(int l1=1; l1<=ln1; ++l1){
//             for(int l2=1; l2<=ln2; ++l2){
//                 dp[l1][l2] = text1.charAt(l1-1)==text2.charAt(l2-1) ? 1+dp[l1-1][l2-1] : Math.max(dp[l1-1][l2], dp[l1][l2-1]);
//             }
//         }
        
//         return dp[ln1][ln2];
//     }
// }