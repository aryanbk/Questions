// partition DP

class Solution {
    Boolean[][] paliMemo;
    public int minCut(String s) {
        paliMemo = new Boolean[s.length()][s.length()];
        return mcm(0, s.length()-1, s, new Integer[s.length()][s.length()]);
    }
    
    private int mcm(int i, int j, String s, Integer[][] memo){
        if(isPalindrome(i, j, s)) return 0;
        
        if(memo[i][j] != null) return memo[i][j];
        
        memo[i][j] = 10000;
        for(int k=i; k<j; ++k){
            if(isPalindrome(k+1, j, s))
            memo[i][j] = Math.min(memo[i][j], mcm(i, k, s, memo) + 1);
        }
        return memo[i][j];
    }
    
    private boolean isPalindrome(int i, int j, String s){
        if(paliMemo[i][j] != null) return paliMemo[i][j];
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                paliMemo[i][j] = false;
                return false;
            }
            i++;
            j--;
        }
        paliMemo[i][j] = true;
        return true;
    }
}


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