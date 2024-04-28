class Solution {
    int[][] dp;
    List<Integer>[] adj;
    int n;
    int[] ans;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.n = n;
        dp = new int[n][2];
        adj = new ArrayList[n];
        ans = new int[n];
        
        for(int i=0; i<n; ++i) adj[i] = new ArrayList<>();
        
        for(int[] e: edges){
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        
        // dfs(0, -1, 0);
        // return dfs(0,-1,0);
        dfs(0, -1, 0);
        ans[0] = dp[0][1];
        
        // for(int[] d: dp)
            // System.out.println(d[0]+" "+d[1]);
        
        dfs2(0, -1, 0);
        return ans;
    }
    
    int[] dfs(int i, int par, int lvl){
        dp[i] = new int[]{1, lvl}; // {nodes, dis}
        
        for(int nbr: adj[i]){
            if(nbr != par){
                int[] res = dfs(nbr, i, lvl+1);
                dp[i][0] += res[0];
                dp[i][1] += res[1];
            }
        }
        
        return dp[i];
    }
    
    void dfs2(int i, int par, int lvl){
        if(par != -1){
            int curcur = dp[i][1] - (lvl*dp[i][0]);
            int curpar = curcur + dp[i][0];
            int otherpar = ans[par] - curpar;
            // int x = dp[i][1] - ((lvl-1)*dp[i][0]);
            int[] up = new int[]{dp[par][0]-dp[i][0], otherpar};
            // System.out.println(up[1]+" "+i);
            // updp[i] = updp[par] + (up[0]+1)*lvl + 
            // ans[i] = dp[i][1] - (dp[i][0]*lvl) + (up[0]*lvl) + up[1];
            ans[i] = curcur + ((n-dp[i][0])) + up[1];
        }
        
        for(int nbr: adj[i]){
            if(nbr != par){
                dfs2(nbr, i, lvl+1);
            }
        }        
        
    }
}










// class Solution {
//     int[][] dp;
//     <List<Integer>[] adj;
//     public int[] sumOfDistancesInTree(int n, int[][] edges) {
//         dp = new int[n][2];
//         adj = new ArrayList[n];
//         for(int i=0; i<n; ++i) adj[i] = new ArrayList<>();
        
//         for(int[] e; edges){
//             adj[e[0]].add(e[1]);
//             adj[e[1]].add(e[0]);
//         }
        
//         dfs(0, -1, 0);
//     }
    
//     int dfs(int i, int par, int lvl ){
//         for(int nbr: adj[i]){
//             if(nbr != par){
                
//             }
//         }
//     }
// }