class Solution {
    int[] dx = new int[]{1, -1, 0, 0, 1, -1, 1, -1};
    int[] dy = new int[]{0, 0, 1, -1, 1, -1, -1, 1};

    public int shortestPathBinaryMatrix(int[][] grid) {
    
        int n = grid.length;
        // no need to use pq
        // PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a->a[2]));
        Queue<int[]> q = new LinkedList<>();
        if(grid[0][0]==1)
            return -1;
        q.offer(new int[]{0, 0, 1});
        grid[0][0] = -1;
        
        while(!q.isEmpty()){
            int i = q.peek()[0];
            int j = q.peek()[1];
            int step = q.peek()[2];
            q.poll();
            
            if(i==n-1 && j==n-1)
                return step;
            
            for(int d=0; d<8; ++d){
                int ii = i+dx[d];
                int jj = j+dy[d];
                if(ii>=0 && ii<n && jj>=0 && jj<n && grid[ii][jj]==0){
                    grid[ii][jj] = -1;
                    q.offer(new int[]{ii, jj, step+1});
                }
            }
        }
        return -1;
    }
}