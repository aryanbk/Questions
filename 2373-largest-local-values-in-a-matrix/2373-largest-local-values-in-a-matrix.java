class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] ans = new int[n-2][n-2];
        for(int i=0; i<n-2; ++i){
            for(int j=0; j<n-2; ++j){
                ans[i][j] = find(grid, i, j);
            }
        }
        
        return ans;
    }
    int find(int[][] grid, int i, int j){
        int ans = -1;
        int n = grid.length;
        for(int x=i; x<i+3 && x<n; ++x){
            for(int y=j; y<j+3 && y<n; ++y){
                ans = Math.max(ans, grid[x][y]);
            }
        }
        return ans;
    }
}