class Solution {
    int ans = Integer.MIN_VALUE;
    public int maxScore(List<List<Integer>> grid) {
        int m = grid.size();
        int n = grid.get(0).size();
        
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                int cur = grid.get(i).get(j);
                if(i>0){
                    int prev = grid.get(i-1).get(j);
                    int diff = cur - prev;
                    ans = Math.max(ans, diff);
                    grid.get(i).set(j, Math.min(grid.get(i).get(j), prev));
                }
                if(j>0){
                    int prev = grid.get(i).get(j-1);
                    int diff = cur - prev;
                    ans = Math.max(ans, diff);
                    grid.get(i).set(j, Math.min(grid.get(i).get(j), prev));
                }
            }
        }
        
        // for(var x: grid)
            // System.out.println(x);
        
        return ans;
    }
}


// // correct answers but TLE
//
// class Solution {
//     int ans= 0;
//     int failover = Integer.MIN_VALUE;
//     Integer[][] memo;
//     int m;
//     int n;
//     public int maxScore(List<List<Integer>> grid) {
//         m = grid.size();
//         n = grid.get(0).size();
//         memo = new Integer[m][n];
        
//         solve(0, 0, grid);
//         return ans != 0 ? ans : failover;
//     }
    
//     int solve(int i, int j, List<List<Integer>> grid){
//         if(memo[i][j] != null)
//             return memo[i][j];
        
//         int res = 0;
//         int cur = grid.get(i).get(j);
        
//         for(int x=i+1; x<m; ++x){
//             int diff = grid.get(x).get(j)-cur;
//             res = Math.max(res, diff + solve(x, j, grid));
//             if(diff<=0) failover = Math.max(failover, diff);
//         }
        
//         for(int y=j+1; y<n; ++y){
//             int diff = grid.get(i).get(y)-cur;
//             res = Math.max(res, diff + solve(i, y, grid));
//             if(diff <= 0) failover = Math.max(failover, diff);
//         }
        
//         memo[i][j] = res;
//         ans = Math.max(res, ans);
//         return res;
//     }
// }