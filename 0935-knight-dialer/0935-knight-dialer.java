class Solution {
    int[][] dir = {{-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}};
    int MOD = 1000000007;
    int[][][] memo;
    public int knightDialer(int n) {
        int ans = 0;
        memo = new int[4][3][n+1];
        for(var i: memo){
            for(var j: i){
                Arrays.fill(j, -1);
            }
        }
        for(int i=0; i<4; ++i){
            for(int j=0; j<3; ++j){
                ans = (ans + help(i, j, n))%MOD;
            }
        }
        return ans;
    }
    private int help(int i, int j, int n){
        if(i<0 || i>=4 || j<0 || j>=3 || (i==3 && j==0) || (i==3 && j==2)) return 0;
        if(n==1) return 1;
        
        if(memo[i][j][n] != -1) return memo[i][j][n];
        
        memo[i][j][n] = 0;
        for(int[] d: dir){
            int x = i + d[0];
            int y = j + d[1];
            memo[i][j][n] = (memo[i][j][n] + help(x, y, n-1))%MOD;
        }
        
        return memo[i][j][n];
    }
}