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
            int col = colFind(grid, r, c, j);
            // System.out.println(col+" "+(m/2));
            if(col < (m+1)/2)
                c[j] = 1;
        }
        
        int ans = 0;
        for(int i=0; i<m; ++i){
            ans += Integer.parseInt(rowFind(grid, r, c, i), 2);
            // System.out.println(ans);
        }
        
        // System.out.println(Arrays.toString(r)+" "+Arrays.toString(c));
        return ans;
        
        // for(int i)
    }
    
    int colFind(int[][] grid, int[] r, int[] c, int j){
        int ans = 0;
        for(int i=0; i<grid.length; ++i)
            ans += (grid[i][j] ^ (r[i] ^ c[j]));
        return ans;
    }
    
    String rowFind(int[][] grid, int[] r, int[] c, int i){
        StringBuilder ans = new StringBuilder();
        for(int j=0; j<grid[i].length; ++j)
            ans.append((grid[i][j] ^ (r[i] ^ c[j]))==1 ? '1' : '0');
        return ans.toString();
    }
}