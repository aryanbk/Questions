class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[] r = new int[m];
        int[] c = new int[n];
        
        for(int i=0; i<m; ++i){
            if(grid[i][0] == 0)
                r[i] = 1;
        }
        
        for(int j=1; j<n; ++j){
            int colVal = colFind(grid, r, c, j);
            if(colVal < (m+1)/2)
                c[j] = 1;
        }
        
        int ans = 0;
        for(int i=0; i<m; ++i){
            int rowVal = rowFind(grid, r, c, i);
            ans += rowVal;
        }
        
        return ans;
    }
    
    int colFind(int[][] grid, int[] r, int[] c, int j){
        int ans = 0;
        for(int i=0; i<grid.length; ++i)
            ans += (grid[i][j] ^ (r[i] ^ c[j]));
        return ans;
    }
    
    int rowFind(int[][] grid, int[] r, int[] c, int i){
        int ans = 0;
        int two = 1;
        for(int j = grid[i].length-1; j >= 0; --j, two *= 2)
            ans += (grid[i][j] ^ (r[i] ^ c[j])) * two;
        return ans;
    }
}











// class Solution {
//     public int matrixScore(int[][] grid) {
//         int m = grid.length;
//         int n = grid[0].length;
        
//         int[] r = new int[m];
//         int[] c = new int[n];
        
//         for(int i=0; i<m; ++i){
//             if(grid[i][0] == 0)
//                 r[i] = 1;
//         }
        
//         for(int j=1; j<n; ++j){
//             int colVal = colFind(grid, r, c, j);
//             if(colVal < (m+1)/2)
//                 c[j] = 1;
//         }
        
//         int ans = 0;
//         for(int i=0; i<m; ++i){
//             String rowVal = rowFind(grid, r, c, i);
//             ans += Integer.parseInt(rowVal, 2);
//         }
        
//         return ans;
//     }
    
//     int colFind(int[][] grid, int[] r, int[] c, int j){
//         int ans = 0;
//         for(int i=0; i<grid.length; ++i)
//             ans += (grid[i][j] ^ (r[i] ^ c[j]));
//         return ans;
//     }
    
//     String rowFind(int[][] grid, int[] r, int[] c, int i){
//         StringBuilder ans = new StringBuilder();
//         for(int j=0; j<grid[i].length; ++j)
//             ans.append((grid[i][j] ^ (r[i] ^ c[j]))==1 ? '1' : '0');
//         return ans.toString();
//     }
// }