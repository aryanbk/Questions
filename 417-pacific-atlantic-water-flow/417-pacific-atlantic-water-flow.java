class Solution {
    static void dfs(int i, int j, int w, int h, int[][] M, byte[] dp, List<List<Integer>> ans) {
        int ij = i * M[0].length + j;
        if ((dp[ij] & w) > 0 || M[i][j] < h) return;
        dp[ij] += w;
        h = M[i][j];
        if (dp[ij] == 3) ans.add(Arrays.asList(i,j));
        if (i + 1 < M.length) dfs(i+1, j, w, h, M, dp, ans);
        if (i > 0) dfs(i-1, j, w, h, M, dp, ans);
        if (j + 1 < M[0].length) dfs(i, j+1, w, h, M, dp, ans);
        if (j > 0) dfs(i, j-1, w, h, M, dp, ans);
    }
    public List<List<Integer>> pacificAtlantic(int[][] M) {
        List<List<Integer>> ans = new ArrayList<>();
        if (M.length == 0) return ans;
        int y = M.length, x = M[0].length;
        byte[] dp = new byte[x * y];
        for (int i = 0; i < x; i++) {
            dfs(0, i, 1, M[0][i], M, dp, ans);
            dfs(y-1, i, 2, M[y-1][i], M, dp, ans);
        }   
        for (int i = 0; i < y; i++) {
            dfs(i, 0, 1, M[i][0], M, dp, ans);
            dfs(i, x-1, 2, M[i][x-1], M, dp, ans);
        }
        return ans;
    }
}

// class Solution {
//     int m;
//     int n;
//     List<List<Integer>> ans;
//     int[][] dpAtl;
//     int[][] dpPac;
//     public List<List<Integer>> pacificAtlantic(int[][] map) {
//         m=map.length;
//         n=map[0].length;
//         dpAtl = new int[m][n];
//         dpPac=new int[m][n];
//         ans=new ArrayList<>();
//         for(int i=0; i<m; i++){
//             for(int j=0; j<n; j++){
//                 // System.out.println("hi");
//                 if(pac(i, j, map, Integer.MAX_VALUE) && atl(i, j, map, Integer.MAX_VALUE)){
//                     ArrayList<Integer> temp=new ArrayList<Integer>();
//                     temp.add(i);
//                     temp.add(j);
//                     ans.add(new ArrayList<>(temp));
//                 }
//             }
//         }
//         return ans;
//     }
//     boolean pac(int i, int j, int[][] map, int last){
//         if(i<0 || j<0) return true;
//         if(i>=m || j>=n || last<map[i][j]) return false;
//         if(dpPac[i][j]!=0) return (dpPac[i][j]==1) ? true : false;
//         boolean ans=pac(i-1, j, map, map[i][j]) || 
//             pac(i, j-1, map, map[i][j]) || 
//             pac(i+1, j, map, map[i][j]) || 
//             pac(i, j+1, map, map[i][j]);
//         if(ans) dpPac[i][j]=1;
//         else dpPac[i][j]=-1;
//         // System.out.println(ans);
//         return ans;
//     }
    
//     boolean atl(int i, int j, int[][] map, int last){
//         if(i>=m || j>=n) return true;
//         if(i<0 || j<0 || last<map[i][j]) return false;
//         if(dpAtl[i][j]!=0) return (dpAtl[i][j]==1) ? true : false;
//         boolean ans = atl(i+1, j, map, map[i][j]) || 
//             atl(i, j+1, map, map[i][j]) ||
//             atl(i-1, j, map, map[i][j]) || 
//             atl(i, j-1, map, map[i][j]);
//         if(ans) dpAtl[i][j]=1;
//         else dpAtl[i][j]=-1;
//         return ans;
//     }
    
// }