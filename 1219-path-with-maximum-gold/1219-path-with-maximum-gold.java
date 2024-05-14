class Solution {
    int m;
    int n;
    int[] dir = {0, 1, 0, -1, 0};
    
    public int getMaximumGold(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int ans = 0;
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                ans = Math.max(ans, bk(i, j, grid));
            }
        }
        return ans;
    }
    
    int bk(int i, int j, int[][] grid){
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j] == 0)
            return 0;
        
        int ans = 0;
        int temp = grid[i][j];
        grid[i][j] = 0;
        
        for(int x=0; x<4; ++x)
            ans = Math.max(ans, bk(i+dir[x], j+dir[x+1], grid));
        
        grid[i][j] = temp;
        return ans + grid[i][j];
        
    }
}



// // first attempt O(3^k)
//
// class Solution {
//     int m;
//     int n;
//     int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
//     public int getMaximumGold(int[][] grid) {
//         m = grid.length;
//         n = grid[0].length;
//         int ans = 0;
//         for(int i=0; i<m; ++i){
//             for(int j=0; j<n; ++j){
//                 ans = Math.max(ans, bk(i, j, grid));
//             }
//         }
//         return ans;
//     }
    
//     int bk(int i, int j, int[][] grid){
//         if(i<0 || i>=m || j<0 || j>=n || grid[i][j] == 0)
//             return 0;
        
//         int ans = 0;
//         int temp = grid[i][j];
//         grid[i][j] = 0;
        
//         for(var d: dir){
//             ans = Math.max(ans, bk(i+d[0], j+d[1], grid));
//         }
        
//         grid[i][j] = temp;
//         return ans + grid[i][j];
        
//     }
// }