class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] r = new int[m];
        int[] c = new int[n];
        
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                r[i] += grid[i][j];
                c[j] += grid[i][j];
            }
        }
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                grid[i][j] = 2*(r[i] + c[j]) - m - n;
            }
        }
        
        return grid;
        
    }
}