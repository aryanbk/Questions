class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans=0;
        for(int i=0, m=grid.length; i<m; i++){
            for(int j=0, n=grid[0].length; j<n; j++){
                if(grid[i][j]==1) ans=Math.max(ans, areabfs(grid, i, j));
            }
        }
        return ans;
    }
    int area(int[][] grid, int i, int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0) return 0;
        grid[i][j]=0;
        return 1+area(grid, i+1, j)+area(grid, i-1, j)+area(grid, i, j+1)+area(grid, i, j-1);
    }
    public int areabfs(int[][] grid, int i, int j) {
        int m = grid.length; // Number of rows
        int n = grid[0].length; // Number of columns
        int ans = 0; // Initialize the count of area

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});

        while (!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.peek()[1];
            q.poll(); 
            if (grid[x][y] == 0)
                continue; // Skip if the cell has already been visited

            grid[x][y] = 0; // Mark the cell as visited
            ++ans; // Increment the count of the area

            // Explore all four directions
            for (int d = 0; d < 4; ++d) {
                int a = x + dx[d]; 
                int b = y + dy[d]; 

                if (a >= 0 && b >= 0 && a < m && b < n && grid[a][b] == 1) {
                    q.offer(new int[]{a, b}); // Add unvisited cell to the queue for further exploration
                }
            }
        }
        return ans; // Return the total count of the area
    }
}