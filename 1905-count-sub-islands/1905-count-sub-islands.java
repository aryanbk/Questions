class Solution {
    int m;
    int n;
    boolean[][] vis;
    int[] dir = {0, 1, 0, -1, 0};
    
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        m = grid1.length;
        n = grid1[0].length;
        vis = new boolean[m][n];
        int ans = 0;
        
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                boolean[] res = dfs(i, j, grid1, grid2);
                // System.out.println(i+" "+j+" "+res[0]+" "+res[1]);
                ans += res[0] & res[1] ? 1 : 0;
            }
        }
        
        return ans;
    }
    
    boolean[] dfs(int i, int j, int[][] grid1, int[][] grid2){
        if(i<0 || i>=m || j<0 || j>=n || grid2[i][j]==0 || vis[i][j]){
            return new boolean[]{false, true};
        }
        if(grid1[i][j]==0 && grid2[i][j]==1) return new boolean[2];
        vis[i][j] = true;
        boolean[] ans = new boolean[]{true, true};
        for(int x=0; x<4; ++x)
            ans[1] &= dfs(i+dir[x], j+dir[x+1], grid1, grid2)[1];
        return ans;
    }
}