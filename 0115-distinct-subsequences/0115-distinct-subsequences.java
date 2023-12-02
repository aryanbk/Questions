// DP - memo
// len to zero
// 
class Solution {
    int[][] memo;
    public int numDistinct(String s, String t) {
        memo = new int[s.length()+1][t.length()+1];
        for(int[] row: memo) Arrays.fill(row, -1);
        
        return solve(s.length(), t.length(), s, t);
    }
    
    private int solve(int i, int j, String s, String t){
        if(j==0) return 1;
        if(i==0) return 0;
        
        if(memo[i][j] != -1) return memo[i][j];
        
        memo[i][j] = solve(i-1, j, s, t);
        if(s.charAt(i-1) == t.charAt(j-1))
            memo[i][j] += solve(i-1, j-1, s, t);
        return memo[i][j];
    }
}


// DP- memo
// 0 to len
//
// class Solution {
//     int[][] memo;
//     public int numDistinct(String s, String t) {
//         memo = new int[s.length()+1][t.length()+1];
//         for(int[] row: memo) Arrays.fill(row, -1);
//         return solve(0, 0, s, t);
//     }
    
//     private int solve(int i, int j, String s, String t){
//         if(j==t.length()) return 1;
//         if(i==s.length()) return 0;
        
//         if(memo[i][j] != -1) return memo[i][j];
        
//         memo[i][j] = solve(i+1, j, s, t);
//         if(s.charAt(i) == t.charAt(j))
//             memo[i][j] += solve(i+1, j+1, s, t);
//         return memo[i][j];
//     }
// }
