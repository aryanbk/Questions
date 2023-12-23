class Solution {
    String[][] memo;
    public String longestPalindrome(String s) {
        int n = s.length();
        memo = new String[n][n];
        return help(s, 0, s.length()-1);
    }
    
    String help(String s, int i, int j){
        if(i==j || isPali(s, i, j)){
            memo[i][j] = s.substring(i, j+1);
            return memo[i][j];
        }
        
        if(memo[i][j] != null) return memo[i][j];
        
        String left = help(s, i+1, j);
        String right = help(s, i, j-1);
        
        memo[i][j] = left.length() >= right.length() ? left : right;
        return memo[i][j];
    }
    
    boolean isPali(String s, int i, int j){
        while(i<j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            ++i;
            --j;
        }
        return true;
    }
}


// // recurssive O(2^n)
//
// class Solution {
//     public String longestPalindrome(String s) {
//         return help(s, 0, s.length()-1);
//     }
    
//     String help(String s, int i, int j){
//         if(i==j || isPali(s, i, j))
//             return s.substring(i, j+1);
        
//         String left = help(s, i+1, j);
//         String right = help(s, i, j-1);
        
//         return left.length() >= right.length() ? left : right;
//     }
    
//     boolean isPali(String s, int i, int j){
//         while(i<j){
//             if(s.charAt(i) != s.charAt(j))
//                 return false;
//             ++i;
//             --j;
//         }
//         return true;
//     }
// }