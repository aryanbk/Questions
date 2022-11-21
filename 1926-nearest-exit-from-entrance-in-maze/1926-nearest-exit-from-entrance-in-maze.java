class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int r = maze.length, c = maze[0].length;
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        int sr = entrance[0], sc = entrance[1];
        maze[sr][sc] = '+';
        
        // Start BFS from the entrance, and use a queue `queue` to store all 
        // the cells to be visited.
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc, 0});
        
        while (!queue.isEmpty()) {
            int[] currState = queue.poll();
            int currRow = currState[0], currCol = currState[1], currDistance = currState[2];

            for (int[] dir : directions) {
                int nextRow = currRow + dir[0], nextCol = currCol + dir[1];

                // If there exists an unvisited empty neighbor:
                if (0 <= nextRow && nextRow < r && 0 <= nextCol && nextCol < c
                   && maze[nextRow][nextCol] == '.') {
                    
                    // If this empty cell is an exit, return distance + 1.
                    if (nextRow == 0 || nextRow == r - 1 || nextCol == 0 || nextCol == c - 1)
                        return currDistance + 1;
                    
                    // Otherwise, add this cell to 'queue' and mark it as visited.
                    maze[nextRow][nextCol] = '+';
                    queue.offer(new int[]{nextRow, nextCol, currDistance + 1});
                }  
            }
        }

        return -1;
    }
}