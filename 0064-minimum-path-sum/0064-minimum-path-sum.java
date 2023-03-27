class Solution {
    public int minPathSum(int[][] grid) {
        return (int)(travel(grid, 0,0,new int[grid.length][grid[0].length]));
    }
    double travel(int[][] grid, int i, int j, int[][] map){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length) return Integer.MAX_VALUE;
        if(i==grid.length-1 && j==grid[0].length-1) return grid[i][j];
        if(map[i][j]==0) map[i][j]=(int)(Math.min(travel(grid, i+1, j, map),travel(grid, i, j+1, map)))+grid[i][j];
        return map[i][j];
    }
}


