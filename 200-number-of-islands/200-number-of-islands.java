class Solution {
    int m;
    int n;
    public int numIslands(char[][] grid) {
        m=grid.length;
        n=grid[0].length;
        int ans=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='1'){
                    dfs(i, j, grid);
                    ans++;
                }
            }
        }
        return ans;
    }
    void dfs(int i, int j, char[][] grid){
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j]!='1') return;
        grid[i][j]='#';
        dfs(i+1,j, grid);
        dfs(i-1,j, grid);
        dfs(i, j+1, grid);
        dfs(i, j-1, grid);
    }
}