class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans=0;
        for(int i=0, m=grid.length; i<m; i++){
            for(int j=0, n=grid[0].length; j<n; j++){
                if(grid[i][j]==1) ans=Math.max(ans, area(grid, i, j));
            }
        }
        return ans;
    }
    int area(int[][] grid, int i, int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0) return 0;
        grid[i][j]=0;
        return 1+area(grid, i+1, j)+area(grid, i-1, j)+area(grid, i, j+1)+area(grid, i, j-1);
    }
}