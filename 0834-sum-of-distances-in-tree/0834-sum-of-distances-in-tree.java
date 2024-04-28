// 2 DFSs
//
class Solution{
    int n;
    List<Integer>[] adj;
    int[][] dp;
    int[] ans;
    
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.n = n;
        dp = new int[n][2];
        ans = new int[n];
        
        adj = new ArrayList[n];
        for(int i=0; i<n; ++i) adj[i] = new ArrayList<>();
        for(int[] e: edges){
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        
        dfs(0, -1, 0);
        ans[0] = dp[0][1];
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
            // Sum of Distances of cur wrt cur
            int curcur = dp[i][1] - (lvl*dp[i][0]);
            // Sum of Distances of cur wrt parent
            int curpar = curcur + dp[i][0];
            // Sum of Distances of other that cur wrt par
            int otherpar = ans[par] - curpar;
            
            ans[i] = curcur + (n-dp[i][0]) + otherpar;
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