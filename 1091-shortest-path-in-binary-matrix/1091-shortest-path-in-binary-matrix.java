class Solution {
    // Define directional arrays for 8 directions
    int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
    int[] dy = {0, 0, 1, -1, 1, -1, -1, 1};

    public int shortestPathBinaryMatrix(int[][] grid) {
        // Get the size of the grid
        int n = grid.length;

        // Use a regular queue instead of a priority queue
        Queue<int[]> q = new LinkedList<>();
        // no need to use pq
        // PriorityQueue<int[]> q = new PriorityQhttps://leetcode.com/problems/shortest-path-in-binary-matrix/ueue<>(Comparator.comparingInt(a->a[2]));

        // Check if the starting point is blocked
        if (grid[0][0] == 1) 
            return -1;

        // Offer the starting point to the queue with initial step 1
        // Mark the starting point as visited
        q.offer(new int[]{0, 0, 1});
        grid[0][0] = -1;

        // BFS traversal
        while (!q.isEmpty()) {
            int i = q.peek()[0];
            int j = q.peek()[1];
            int step = q.peek()[2];
            q.poll();

            // Check if reached the destination
            if (i == n - 1 && j == n - 1)
                return step;

            // Explore all 8 directions
            for (int d = 0; d < 8; ++d) {
                int ii = i + dx[d];
                int jj = j + dy[d];

                // Check if the next position is within bounds and is an open cell
                if (ii >= 0 && ii < n && jj >= 0 && jj < n && grid[ii][jj] == 0) {
                    // Mark the next position as visited
                    grid[ii][jj] = -1;
                    // Enqueue the next position with the incremented step
                    q.offer(new int[]{ii, jj, step + 1});
                }
            }
        }

        // If the destination is not reached
        return -1;
    }
}