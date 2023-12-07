class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] paliMemo = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            paliMemo[i][i] = true;
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && (len <= 2 || paliMemo[i + 1][j - 1])) {
                    paliMemo[i][j] = true;
                }
            }
        }

        int[] dp = new int[n];

        for (int j = 0; j < n; j++) {
            if (paliMemo[0][j]) {
                dp[j] = 0;
                continue;
            }
            dp[j] = j;
            for (int i = 1; i <= j; i++) {
                if (paliMemo[i][j]) {
                    dp[j] = Math.min(dp[j], dp[i - 1] + 1);
                }
            }
        }

        return dp[n - 1];
    }
}



// // DP - tabulation
// // TLE

// class Solution {
//     Boolean[][] paliMemo;
//     public int minCut(String s) {
//         int n = s.length();
//         paliMemo = new Boolean[n][n];
//         int[][] dp = new int[n][n];
        
//         for(int i=n-1; i>=0; --i){
//             for(int j=i+1; j<n; ++j){
//                 if(isPalindrome(i,j, s)) 
//                     dp[i][j] = 0;
//                 else{
//                     dp[i][j] = 10000;
//                     for(int k=i; k<j; ++k){
//                         if(isPalindrome(k+1, j, s))
//                             dp[i][j] = Math.min(dp[i][j], 1+dp[i][k]);
//                     }
//                 }
//             }
//         }
//         // for(int[] row: dp)
//         // System.out.println(Arrays.toString(row));
//         return dp[0][n-1];
//     }
    
//     private boolean isPalindrome(int i, int j, String s){
//         if(paliMemo[i][j] != null) return paliMemo[i][j];
//         while(i<j){
//             if(s.charAt(i) != s.charAt(j)){
//                 paliMemo[i][j] = false;
//                 return false;
//             }
//             i++;
//             j--;
//         }
//         paliMemo[i][j] = true;
//         return true;
//     }
// }


// // Accepted
// // 
// // partition DP
// // reversed isPalindrome parameters in for loop eg isPalindrome(k+1, j, s)
// // so it starts from longer string and not single chars
// // Also added memo for palidromes so we dont have to calculate it again and again
// //
// class Solution {
//     Boolean[][] paliMemo;
//     public int minCut(String s) {
//         paliMemo = new Boolean[s.length()][s.length()];
//         return mcm(0, s.length()-1, s, new Integer[s.length()][s.length()]);
//     }
    
//     private int mcm(int i, int j, String s, Integer[][] memo){
//         if(isPalindrome(i, j, s)) return 0;
        
//         if(memo[i][j] != null) return memo[i][j];
        
//         memo[i][j] = 10000;
//         for(int k=i; k<j; ++k){
//             if(isPalindrome(k+1, j, s))
//             memo[i][j] = Math.min(memo[i][j], mcm(i, k, s, memo) + 1);
//         }
//         return memo[i][j];
//     }
    
//     private boolean isPalindrome(int i, int j, String s){
//         if(paliMemo[i][j] != null) return paliMemo[i][j];
//         while(i<j){
//             if(s.charAt(i) != s.charAt(j)){
//                 paliMemo[i][j] = false;
//                 return false;
//             }
//             i++;
//             j--;
//         }
//         paliMemo[i][j] = true;
//         return true;
//     }
// }


// // partition DP
// // this is giving TLE because it checks all single chars
// //
// class Solution {
//     public int minCut(String s) {
//         return mcm(0, s.length()-1, s, new Integer[s.length()][s.length()]);
//     }
    
//     private int mcm(int i, int j, String s, Integer[][] memo){
//         if(isPalindrome(i, j, s)) return 0;
        
//         if(memo[i][j] != null) return memo[i][j];
        
//         memo[i][j] = 10000;
//         for(int k=i; k<j; ++k){
//             if(isPalindrome(i, k, s))
//             memo[i][j] = Math.min(memo[i][j], mcm(k+1, j, s, memo) + 1);
//         }
//         return memo[i][j];
//     }
    
//     private boolean isPalindrome(int i, int j, String s){
//         while(i<j){
//             if(s.charAt(i) != s.charAt(j))
//                 return false;
//             i++;
//             j--;
//         }
//         return true;
//     }
// }


// // classic mcm wont work here
// // because it take O(n^3) TC
// // instead of checking all the possibilities (brute force) here
// // we need to use partition DP here

// class Solution {
//     public int minCut(String s) {
//         return mcm(0, s.length()-1, s, new Integer[s.length()][s.length()]);
//     }
    
//     private int mcm(int i, int j, String s, Integer[][] memo){
//         if(isPalindrome(i, j, s)) return 0;
        
//         if(memo[i][j] != null) return memo[i][j];
        
//         memo[i][j] = 10000;
//         for(int k=i; k<j; ++k){
//             memo[i][j] = Math.min(memo[i][j], mcm(i, k, s, memo) + mcm(k+1, j, s, memo) + 1);
//         }
//         return memo[i][j];
//     }
    
//     private boolean isPalindrome(int i, int j, String s){
//         while(i<j){
//             if(s.charAt(i) != s.charAt(j))
//                 return false;
//             i++;
//             j--;
//         }
//         return true;
//     }
// }