class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] adj = new ArrayList[n+1];
        for(int i=0; i<n+1; ++i) adj[i] = new ArrayList<>();
        for(int[] e: dislikes){
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        
        int[] map = new int[n+1];
        for(int i=1; i<n+1; ++i){
            if(map[i]==0){
                if(!dfs(i, 1, map, adj)) return false;
            }
        }
        return true;
    }
    
    boolean dfs(int node, int color, int[] map, List<Integer>[] adj){
        if(map[node] == 0){
            map[node] = color;
            for(int nbr: adj[node])
                if(!dfs(nbr, color*-1, map, adj)) return false;
        }
        return map[node] == color;
    }
}