class Solution {
    // Define directional arrays for 4 directions
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int minimumEffortPath(int[][] heights) {
        // Get the dimensions of the matrix
        int n = heights.length;
        int m = heights[0].length;

        // Use a priority queue to store positions with their efforts, sorted by effort
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        // Add the starting point with zero effort to the priority queue
        pq.add(new int[]{0, 0, 0});
        // Create a 2D array to store the efforts at each position
        int[][] effort = new int[n][m];

        // Initialize the effort array with maximum values
        for (int[] e : effort)
            Arrays.fill(e, Integer.MAX_VALUE);

        // Dijkstra's algorithm
        while (!pq.isEmpty()) {
            int i = pq.peek()[0];
            int j = pq.peek()[1];
            int eff = pq.peek()[2];
            pq.poll();

            // Skip if the current effort is greater than the recorded effort
            if (eff > effort[i][j])
                continue;

            // Record the effort at the current position
            effort[i][j] = eff;

            // Explore all 4 directions
            for (int d = 0; d < 4; ++d) {
                int x = i + dx[d];
                int y = j + dy[d];

                // Check if the next position is within bounds
                if (x >= 0 && x < n && y >= 0 && y < m) {
                    // Calculate the new effort
                    int newEff = Math.max(eff, Math.abs(heights[i][j] - heights[x][y]));

                    // Update the effort and add the position to the priority queue if the new effort is smaller
                    if (newEff < effort[x][y]) {
                        effort[x][y] = newEff;
                        pq.offer(new int[]{x, y, newEff});
                    }
                }
            }
        }

        // Return the effort required to reach the bottom-right cell
        return effort[n - 1][m - 1];
    }
}



// class Solution {
//     int[] dx = {1, -1, 0, 0};
//     int[] dy = {0, 0, 1, -1};
    
//     public int minimumEffortPath(int[][] heights) {
//         int n = heights.length;
//         int m = heights[0].length;
//         PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[2]));
//         pq.add(new int[]{0, 0, 0});
        
//         int[][] effort = new int[n][m];
//         for(int[] e: effort)
//             Arrays.fill(e, Integer.MAX_VALUE);
        
//         while(!pq.isEmpty()){
//             int i = pq.peek()[0];
//             int j = pq.peek()[1];
//             int eff = pq.peek()[2];
//             pq.poll();
            
//             if(eff > effort[i][j])
//                 continue;
//             effort[i][j] = eff; //for heights = [[3]] testcase
            
//             for(int d=0; d<4; ++d){
//                 int x = i+dx[d];
//                 int y = j+dy[d];
//                 if(x>=0 && x<n && y>=0 && y<m){
//                     int newEff = Math.max(eff, Math.abs(heights[i][j] - heights[x][y]));
//                     if(newEff < effort[x][y]){
//                         effort[x][y] = newEff;
//                         pq.offer(new int[]{x, y, newEff});
//                     }
//                 }
                
//             }
//         }
//         return effort[n-1][m-1];
//     }
// }