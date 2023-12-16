class Solution {
    int m;
    int n;
    int k;
    Integer[][][] memo;
    int MOD = 1_000_000_007;
    
    public int numberOfPaths(int[][] grid, int kk) {
        m = grid.length;
        n = grid[0].length;
        k = kk;
        memo = new Integer[m][n][k];
        
        return help(0, 0, 0, grid);
    }
    
    private int help(int i, int j, int rem, int[][] grid){
        if(i<0 || i>=m || j<0 || j>=n)
            return 0;
        if(i==m-1 && j==n-1)
            return (rem+grid[i][j])%k==0 ? 1 : 0;
        
        if(memo[i][j][rem] != null)
            return memo[i][j][rem];
        
        int newRem = (rem + grid[i][j])%k;
        memo[i][j][rem] = (help(i+1, j, newRem, grid) + help(i, j+1, newRem, grid))%MOD;
        
        return memo[i][j][rem];
    }
}