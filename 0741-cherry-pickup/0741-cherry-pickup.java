class Solution {
    int m;
    int n;
    Integer[][][][] memo;
    public int cherryPickup(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        memo = new Integer[m][n][m][n];
        
        return Math.max(0, help(0, 0, 0, 0, grid));
    }

    private int help(int i, int j, int x, int y, int[][] grid) {
        if (i >= m || j >= n || x >= m || y >= n || grid[i][j] == -1 || grid[x][y] == -1) {
            return Integer.MIN_VALUE;
        }

        if (i == m - 1 && j == n - 1 && x == m - 1 && y == n - 1) {
            return grid[i][j];
        }
        
        if(memo[i][j][x][y] != null){
            return memo[i][j][x][y];
        }

        memo[i][j][x][y] = Math.max(
            Math.max(help(i + 1, j, x + 1, y, grid), help(i, j + 1, x + 1, y, grid)),
            Math.max(help(i + 1, j, x, y + 1, grid), help(i, j + 1, x, y + 1, grid))
        );

        memo[i][j][x][y] += (i == x && j == y) ? grid[i][j] : grid[i][j] + grid[x][y];

        return memo[i][j][x][y];
    }
}
