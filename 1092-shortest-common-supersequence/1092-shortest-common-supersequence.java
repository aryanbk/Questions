class Solution {
    // int[][] memo;
    public String shortestCommonSupersequence(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        int[][] dp = new int[l1+1][l2+1];
        
        for(int i=0; i<=l1; ++i){
            for(int j=0; j<=l2; ++j){
                if(i==0 || j==0) dp[i][j] = i+j;
                else if(str1.charAt(i-1) == str2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else{
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])+1;
                }
            }
        }
        
        // for(int[] m1: dp) System.out.println(Arrays.toString(m1));
        return findSequenceFromDp(dp, str1, str2);
    }

    private String findSequenceFromDp(int[][] dp, String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        char[] ans = new char[dp[l1][l2]];
        int i = l1, j = l2;
        int ptr = ans.length - 1;

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                ans[ptr] = s1.charAt(i - 1);
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                ans[ptr] = s2.charAt(j - 1);
                j--;
            } else {
                ans[ptr] = s1.charAt(i - 1);
                i--;
            }
            ptr--;
        }

        while (i > 0) {
            ans[ptr] = s1.charAt(i - 1);
            i--;
            ptr--;
        }

        while (j > 0) {
            ans[ptr] = s2.charAt(j - 1);
            j--;
            ptr--;
        }

        return new String(ans);
    }

    // wont work
    //
    // private String findSequenceFromDp(int[][] dp, String s1, String s2){
    //     int l1 = s1.length();
    //     int l2 = s2.length();
    //     char[] ans = new char[dp[l1][l2]];
    //     int i=l1;
    //     int j=l2;
    //     int ptr = 0;  
    //     while(i>0 && j>0){
    //         if(dp[i][j] == dp[i-1][j-1]){
    //             ans[ptr] = s1.charAt(i-1);
    //             ptr++;
    //             --i;
    //             --j;
    //         }
    //         else if(i>0 && dp[i][j] == dp[i-1][j]){
    //             ans[ptr] = s1.charAt(i-1);
    //             ptr++;
    //             --i;
    //         }
    //         else{
    //             ans[ptr] = s2.charAt(j-1);
    //             ptr++;
    //             --j;
    //         }
    //         // if(dp[i][j])
    //     }
    //     while(i>0){
    //         ans[ptr] = s1.charAt(i-1);
    //         ptr++;
    //         --i;
    //     }
    //     while(j>0){
    //         ans[ptr] = s2.charAt(j-1);
    //         ptr++;
    //         --j;
    //     }
    //     i=0;
    //     j=ans.length-1;
    //     while(i<j){
    //         char temp = ans[i];
    //         ans[i] = ans[j];
    //         ans[j] = temp;
    //         ++i;
    //         --j;
    //     }
    //     return new String(ans);
    // }
    // private int help(int i, int j, String s1, String s2){
    //     if(i==s1.length() || j==s2.length())
    //         return s1.length() + s2.length() - i - j;
    //     if(memo[i][j] != -1) return memo[i][j];
    //     if(s1.charAt(i) == s2.charAt(j)) memo[i][j] = 1+help(i+1, j+1, s1, s2);
    //     else memo[i][j] = Math.min(help(i+1, j, s1, s2), help(i, j+1, s1, s2)) + 1;
    //     return memo[i][j];
    // }
}


// recurssion + memo
// to print length of Supersequence
//
// class Solution {
//     int[][] memo;
//     public String shortestCommonSupersequence(String str1, String str2) {
//         memo = new int[str1.length()][str2.length()];
//         for(int[] m1: memo) Arrays.fill(m1, -1);
//         System.out.println(help(0, 0, str1, str2));
//         return "";
//     }
//     private int help(int i, int j, String s1, String s2){
//         if(i==s1.length() || j==s2.length())
//             return s1.length() + s2.length() - i - j;
//         if(memo[i][j] != -1) return memo[i][j];
//         if(s1.charAt(i) == s2.charAt(j)) memo[i][j] = 1+help(i+1, j+1, s1, s2);
//         else memo[i][j] = Math.min(help(i+1, j, s1, s2), help(i, j+1, s1, s2)) + 1;
//         return memo[i][j];
//     }
// }


// recussion without dp
// to print length of Supersequence
//
// class Solution {
//     public String shortestCommonSupersequence(String str1, String str2) {
//         System.out.println(help(0, 0, str1, str2));
//         return "";
//     }
//     private int help(int i, int j, String s1, String s2){
//         if(i==s1.length() || j==s2.length())
//             return s1.length() + s2.length() - i - j;
//         if(s1.charAt(i) == s2.charAt(j)) return 1+help(i+1, j+1, s1, s2);
//         return Math.min(help(i+1, j, s1, s2), help(i, j+1, s1, s2)) + 1;
//     }
// }