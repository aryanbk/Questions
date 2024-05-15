class Solution {
    int[] dir = {0, -1, 0, 1, 0};
    int n;
    // int[][] memo;
    
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        n = grid.size();
        // memo = new int[n][n];
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0; i<n; ++i){
            for(int j=0; j<n; ++j){
                if(grid.get(i).get(j)==1){
                    q.offer(new int[]{i, j});
                    // grid.get(i).set(j, 0);
                }
            }
        }
        // System.out.println(grid+" "+q.size());
        
        for(int step=1; !q.isEmpty(); ++step){
            int l = q.size();
            // for(var qq: q)
                // System.out.println(Arrays.toString(qq));
            for(int x=0; x<l; ++x){
                int i = q.peek()[0];
                int j = q.peek()[1];
                q.poll();
                
                if(grid.get(i).get(j) > 1 || (grid.get(i).get(j)==1 && step!=1))
                    continue;
                grid.get(i).set(j, step);
                // System.out.println(grid.get(i).get(j)+" "+step);
                
                for(int d=0; d<4; ++d){
                    int a = i + dir[d];
                    int b = j + dir[d+1];
                    if(a>=0 && a<n && b>=0 && b<n)
                        q.offer(new int[]{a, b});
                }
            }
        }
        // System.out.println(grid);
        // int ans = dfs(0, 0, grid);
        // for(var m: memo)
            // System.out.println(Arrays.toString(m));
        // return ans;
        // return dfs(0, 0, grid)-1;
        
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->-a[0]));
        pq.offer(new int[]{grid.get(0).get(0), 0, 0});
        grid.get(0).set(0, -1*grid.get(0).get(0));
        while(pq.peek()[1]<n-1 || pq.peek()[2]<n-1){
            // System.out.println(Arrays.toString(pq.peek()));
            int g = pq.peek()[0];
            int i = pq.peek()[1];
            int j = pq.peek()[2];
            pq.poll();
            
            for(int d=0; d<4; ++d){
                int a = i+dir[d];
                int b = j+dir[d+1];
                if(a>=0 && b>=0 && a<n && b<n && grid.get(a).get(b)>0){
                    pq.offer(new int[]{Math.min(grid.get(a).get(b), g), a, b});
                    grid.get(a).set(b, -1*grid.get(a).get(b));
                }
            }
        }
        return pq.peek()[0] - 1;
    }
    
//     int dfs(int i, int j, List<List<Integer>> grid){
//         if(i==n-1 && j == n-1)
//             return grid.get(i).get(j);
        
        
//         int temp = grid.get(i).get(j);
//         int other = 1;
//         grid.get(i).set(j, -1);
            
//         for(int d=0; d<4; ++d){
//                     int a = i + dir[d];
//                     int b = j + dir[d+1];
//             if(a>=0 && a<n && b>=0 && b<n && grid.get(a).get(b) != -1)
//                 other = Math.max(other, dfs(a, b, grid));
//         }
//         // System.out.println(i+" "+j+" "+cur+" "+other);
//         grid.get(i).set(j, temp);
//         return Math.min(temp, other);
//         // memo[i][j] = Math.min(cur, other);
//         // return Math.min(cur, other);
//         // return memo[i][j];
//     }
}