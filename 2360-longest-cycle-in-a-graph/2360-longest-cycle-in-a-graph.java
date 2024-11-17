class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        int[] indeg = new int[n];
        boolean[] vis = new boolean[n];
        
        for(int i=0; i<n; ++i){
            if(edges[i] != -1) ++indeg[edges[i]];
        }
        
        var q = new LinkedList<Integer>();
        for(int i=0; i<n; ++i){
            if(indeg[i]==0) q.offer(i);
        }
        
        while(!q.isEmpty()){
            int node = q.poll();
            vis[node] = true;
            int nbr = edges[node];
            if(nbr !=-1){
                --indeg[nbr];
                if(indeg[nbr]==0) q.offer(nbr);
            }
        }
        
        int ans = -1;
        for(int i=0; i<n; ++i){
            if(!vis[i]){
                ans = Math.max(ans, cycle(i, edges, vis));
            }
        }
        
        return ans;
        
    }
    
    int cycle(int i, int[] edges, boolean[] vis){
        if(vis[i]) return 0;
        vis[i] = true;
        return cycle(edges[i], edges, vis) + 1;
    }
}


// class Solution {
//     boolean[] vis;
//     public int longestCycle(int[] edges) {
//         int n = edges.length;
//         // int[] depth = new int[n];
//         vis = new boolean[n];
//         int ans = -1;
        
//         for(int i=0; i<n; ++i){
//             ans = Math.max(ans, dfs(i, 1, edges, new int[n]));
//         }
        
//         return ans;
//     }
    
//     int dfs(int i, int num, int[] edges, int[] depth){
//         if(vis[i]) return -1;
//         if(depth[i] != 0){
//             while(!vis[i]){
//                 vis[i] = true;
//                 i = edges[i];
//             }
//             return num-depth[i];
//         }
//         depth[i] = num;
//         return edges[i]!=-1 ? dfs(edges[i], num+1, edges, depth) : -1;
//     }
// }