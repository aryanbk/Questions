class Solution {
    int n;
    boolean[][][] vis;
    int[] forward = {3, 2, 1, 0};
    int[] backward = {1, 0, 3, 2};
    int[][] move = {{-1, 0, 2}, {0, 1, 3}, {1, 0, 0}, {0, -1, 1}};
    
    public int regionsBySlashes(String[] grid) {
        n = grid.length;
        vis = new boolean[n][n][4];
        int ans = 0;
        
        for(int i=0; i<n; ++i){
            for(int j=0; j<n; ++j){
                for(int k=0; k<4; ++k){
                    ans += dfs(i, j, k, grid) ? 1 : 0;
                }
            }
        }
        return ans;
    }
    
    boolean dfs(int i, int j, int k, String[] grid){
        if(i<0 || j<0 || i>=n || j>=n) return false;
        if(vis[i][j][k]) return false;
        
        vis[i][j][k] = true;
        boolean ans = true;
        
        ans |= dfs(i+move[k][0], j+move[k][1], move[k][2], grid);
        if(grid[i].charAt(j) == '/')
            ans |= dfs(i, j, forward[k], grid);
        else if(grid[i].charAt(j) == '\\')
            ans |= dfs(i, j, backward[k], grid);
        else if(grid[i].charAt(j) == ' '){
            for(int x=0; x<4; ++x)
                ans |= dfs(i, j, x, grid);
        }
        
        return ans;
    }
}