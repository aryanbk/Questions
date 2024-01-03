class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                if(isWater[i][j] == 1)
                    q.offer(new int[]{i, j});
            }
        }
        
        int lvl = 0;
        int[] dir = {0, 1, 0, -1, 0};
        int[][] ans = new int[m][n];
        for(int[] row: ans) Arrays.fill(row, -1);
        
        while(!q.isEmpty()){
            int l = q.size();
            for(int p=0; p<l; ++p){
                int i = q.peek()[0];
                int j = q.peek()[1];
                q.poll();
                
                if(ans[i][j] != -1)
                    continue; // Important
                
                ans[i][j] = lvl;

                for(int a=0; a<4; ++a){
                    int x = i + dir[a];
                    int y = j + dir[a+1];
                    
                    if(x>=0 && x<m && y>=0 && y<n && ans[x][y] == -1)
                        q.offer(new int[]{x, y});
                }
            }
            ++lvl;
            
        }
        
        return ans;
    }
}