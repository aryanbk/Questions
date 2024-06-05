class Solution {
    Boolean[][] memo;
    
    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length()+1][p.length()+1];
        return solve(s.length(), p.length(), s, p);
    }
    
    private boolean solve(int i, int j, String s, String p){
        if(i==0 && j==0) return true;
        if(i!=0 && j==0) return false;
        if(i==0 && j!=0){
            while(j>0 && p.charAt(j-1)=='*') j-=2;
            return j<=0;
        }
        
        if(memo[i][j] != null)
            return memo[i][j];
        
        if(p.charAt(j-1)=='.' || p.charAt(j-1) == s.charAt(i-1))
            memo[i][j] = solve(i-1, j-1, s, p);
        else if(p.charAt(j-1)=='*'){
            if(j>1){
                if(p.charAt(j-2) == s.charAt(i-1) || p.charAt(j-2) == '.')
                    memo[i][j] = solve(i-1, j, s, p) || solve(i, j-2, s, p);
                else
                    memo[i][j] = solve(i, j-2, s, p);
            }
        }
        else
            memo[i][j] = false;
        
        return memo[i][j];
    }
}





// class Solution {
//     int[][] memo;
//     public boolean isMatch(String s, String p) {
//         memo = new int[s.length()+1][p.length()+1];
//         return solve(s.length(), p.length(), s, p);
//     }
//     private boolean solve(int i, int j, String s, String p){
//         if(i==0 && j==0) return true;
//         if(i!=0 && j==0) return false;
//         if(i==0 && j!=0){
//             if(p.charAt(j-1)=='*') return solve(i, j-1, s, p);
//             else return false;
//         }
        
//         if(memo[i][j] != -1)
//             return memo[i][j]==1;
        
//         if(p.charAt(j-1)=='.' || p.charAt(j-1) == s.charAt(i-1))
//             memo[i][j] = solve(i-1, j-1, s, p) ? 1 : 0;
//         else if(p.charAt(j-1)=='*')
//             memo[i][j] = solve(i-1, j, s, p) || solve(i, j-1, s, p) || solve(i-1, j-1, s, p) ? 1 : 0;
//         return memo[i][j] == 1;
//     }
// }