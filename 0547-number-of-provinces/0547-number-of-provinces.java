class Solution {
    boolean[] vis;
    int n;
    public int findCircleNum(int[][] edge) {
        n = edge.length;
        vis = new boolean[n];
        int ans = 0;
        
        for(int i=0; i<n; ++i){
            if(!vis[i]){
                bfs(i, edge);
                ++ans;
            }
        }
        
        return ans;
    }
    
    private void bfs(int i, int[][] mat){
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        while(!q.isEmpty()){
            int node = q.poll();
            vis[node] = true;
            for(int j=0; j<n; ++j){
                if(mat[node][j]==1 && !vis[j])
                    q.offer(j);
            }
        }
    }
    
}