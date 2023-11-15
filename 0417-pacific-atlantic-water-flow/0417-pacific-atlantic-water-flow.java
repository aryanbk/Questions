class Solution {
    int m;
    int n;
    int[] dx = new int[]{1, -1, 0, 0};
    int[] dy = new int[]{0, 0, 1, -1};
    public List<List<Integer>> pacificAtlantic(int[][] h) {
        m = h.length;
        n = h[0].length;
        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];
        Queue<int[]> pQ = new LinkedList<>();
        Queue<int[]> aQ = new LinkedList<>();
        for(int i=0; i<m; ++i){
            pQ.offer(new int[]{i, 0});
            aQ.offer(new int[]{i, n-1});
        }
        for(int i=0; i<n; ++i){
            pQ.offer(new int[]{0, i});
            aQ.offer(new int[]{m-1, i});
        }
        bfs(h, pQ, pac);
        bfs(h, aQ, atl);
        
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                if(pac[i][j] && atl[i][j]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    ans.add(temp);
                }
            }
        }
        return ans;
    }
    
    private void bfs(int[][] h, Queue<int[]> q, boolean[][] vis){
        while(!q.isEmpty()){
            int i = q.peek()[0];
            int j = q.peek()[1];
            q.poll();
            
            vis[i][j] = true;
            
            for(int d=0; d<4; ++d){
                int x = i+dx[d];
                int y = j+dy[d];
                if(x>=0 && y>=0 && x<m && y<n && h[i][j]<=h[x][y] && !vis[x][y]){
                    q.offer(new int[]{x, y});
                }
            }
        }
    }
    
}


// wrong answer
// class Solution {
//     int[] dx = new int[]{1, -1, 0, 0};
//     int[] dy = new int[]{0, 0, 1, -1};
//     int m;
//     int n;
//     int[][] pac;
//     int[][] atl;
    
//     public List<List<Integer>> pacificAtlantic(int[][] h) {
//         m = h.length;
//         n = h[0].length;
//         pac = new int[m][n];
//         atl = new int[m][n];
        
//         List<List<Integer>> ans = new ArrayList<>();
        
//         for(int i=0; i<m; ++i){
//             for(int j=0; j<n; ++j){
//                 boolean[] dfsans = dfs(h, i, j, Integer.MAX_VALUE);
//                 System.out.println(i+" "+j+" "+Arrays.toString(dfsans));
//                 if(dfsans[2]){
//                     List<Integer> x = new ArrayList<>();
//                     x.add(i);
//                     x.add(j);
//                     ans.add(x);
//                 }
//             }
//         }
        
//         return ans;
//     }
    
//     private boolean[] dfs(int[][] h, int i, int j, int prev){
//         if(i<0 || j<0)
//             return new boolean[]{true, false, false};
//         if(i>=m || j>=n)
//             return new boolean[]{false, true, false};
//         if(pac[i][j]!=0 || atl[i][j]!=0){
//             boolean p = pac[i][j]==1 ? true : false;
//             boolean a = atl[i][j]==1 ? true : false;
//             return new boolean[]{p, a, p&&a};
//         }
//         if(h[i][j] > prev)
//             return new boolean[]{false, false, false};
//         boolean p = false;
//         boolean a = false;
//         boolean x = false;
//         int temp = h[i][j];
//         h[i][j] = Integer.MAX_VALUE;
//         for(int d=0; d<4 && !(p && a); ++d){
//             boolean[] res = dfs(h, i+dx[d], j+dy[d], temp);
//             p = p || res[0];
//             a = a || res[1];
//             x = x || res[2];
//         }
//         x = x || (p && a);
//         h[i][j] = temp;
//         pac[i][j] = p ? 1 : -1;
//         atl[i][j] = a ? 1 : -1;
//         return new boolean[]{p, a, x};
//     }
// }



// working code but giving tle
// class Solution {
//     int[] dx = new int[]{1, -1, 0, 0};
//     int[] dy = new int[]{0, 0, 1, -1};
//     int m;
//     int n;
//     public List<List<Integer>> pacificAtlantic(int[][] h) {
//         m = h.length;
//         n = h[0].length;
//         List<List<Integer>> ans = new ArrayList<>();
//         for(int i=0; i<m; ++i){
//             for(int j=0; j<n; ++j){
//                 boolean[] dfsans = dfs(h, i, j, Integer.MAX_VALUE);
//                 // System.out.println(i+" "+j+" "+Arrays.toString(dfsans));
//                 if(dfsans[2]){
//                     List<Integer> x = new ArrayList<>();
//                     x.add(i);
//                     x.add(j);
//                     ans.add(x);
//                 }
//             }
//         }
//         return ans;
//     }
    
//     private boolean[] dfs(int[][] h, int i, int j, int prev){
//         if(i<0 || j<0)
//             return new boolean[]{true, false, false};
//         if(i>=m || j>=n)
//             return new boolean[]{false, true, false};
//         if(h[i][j] == Integer.MAX_VALUE || h[i][j] > prev)
//             return new boolean[]{false, false, false};
//         boolean p = false;
//         boolean a = false;
//         boolean x = false;
//         int temp = h[i][j];
//         h[i][j] = Integer.MAX_VALUE;
//         for(int d=0; d<4; ++d){
//             boolean[] res = dfs(h, i+dx[d], j+dy[d], temp);
//             p = p || res[0];
//             a = a || res[1];
//             x = x || res[2];
//         }
//         x = x || (p && a);
//         h[i][j] = temp;
//         return new boolean[]{p, a, x};
//     }
// }