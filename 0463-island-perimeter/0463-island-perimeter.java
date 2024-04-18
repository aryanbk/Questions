class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                if(grid[i][j]==1){
                    ans += i==0 || grid[i-1][j]==0 ? 1 : 0;
                    ans += j==0 || grid[i][j-1]==0 ? 1 : 0;
                    ans += i==m-1 || grid[i+1][j]==0 ? 1 : 0;
                    ans += j==n-1 || grid[i][j+1]==0 ? 1 : 0;
                }
            }
        }
        return ans;
    }
}