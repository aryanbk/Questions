class Solution {
    int m;
    int n;
    public int numMagicSquaresInside(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int ans = 0;
        
        if(m<3 || n<3) return ans;
        
        for(int i=0; i+2<m; ++i){
            for(int j=0; j+2<n; ++j){
                // System.out.println(i+" "+j+" "+m+" "+n);
                if(valid(i, j, grid)) ++ans;
            }
        }
        
        return ans;
    }
    
    boolean valid(int i, int j, int[][] grid){
        int[] row = new int[3];
        int[] col = new int[3];
        boolean[] uniq = new boolean[9];
        // System.out.println(i+" "+j);
        for(int x=i; x<i+3; ++x){
            for(int y=j; y<j+3; ++y){
                int val = grid[x][y];
                // System.out.println("xy "+x+" "+y);
                row[x-i] += val;
                col[y-j] += val;
                if(val==0 || val>9 || uniq[val-1]) return false;
                uniq[val-1] = true;
            }
        }
        if(!(row[0]==row[1] && row[0]==row[2])) return false;
        if(!(col[0]==col[1] && col[0]==col[2])) return false;
        return grid[i][j]+grid[i+2][j+2] == grid[i][j+2]+grid[i+2][j];
    }
}