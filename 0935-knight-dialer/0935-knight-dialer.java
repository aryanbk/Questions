class Solution {
    int[][] dir = {{-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}};
    int MOD = 1_000_000_007;
    int[][][] memo;
    
    public int knightDialer(int n) {
        int ans = 0;
        memo = new int[4][3][n+1];
        
        for(var m1: memo){
            for(var m2: m1){
                Arrays.fill(m2, -1);
            }
        }
        
        for(int i=0; i<4; ++i){
            for(int j=0; j<3; ++j){
                ans = (ans + recurssive(i, j, n))%MOD;
            }
        }
        
        return ans;
    }
    private int recurssive(int i, int j, int n){
        if(i<0 || i>=4 || j<0 || j>=3 || (i == 3 && (j == 0 || j == 2))) return 0;
        if(n==1) return 1;
        
        if(memo[i][j][n] != -1) return memo[i][j][n];
        
        memo[i][j][n] = 0;
        for(int[] d: dir)
            memo[i][j][n] = (memo[i][j][n] + recurssive(i+d[0], j+d[1], n-1))%MOD;
        
        return memo[i][j][n];
    }
}