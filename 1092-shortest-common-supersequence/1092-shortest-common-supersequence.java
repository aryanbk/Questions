// dp - tabulation
// TC O(l1 * l2)
// SC O(l1 * l2)
// space opti - O(l1)
//
class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];

        for (int i = 0; i <= l1; ++i) {
            for (int j = 0; j <= l2; ++j) {
                if (i == 0 || j == 0) dp[i][j] = i + j;
                else if (str1.charAt(i - 1) == str2.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
                else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }

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
}

// first attempt dp - tabulation code https://leetcode.com/submissions/detail/1109097230/

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