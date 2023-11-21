class Solution {
    int[] par;
    public int findCircleNum(int[][] mat) {
        int n = mat.length;
        par = new int[n];
        Arrays.setAll(par, i->i);
        
        for(int i=0; i<n; ++i){
            for(int j=0; j<n; ++j){
                if(i!=j && mat[i][j]==1)
                    union(i, j);
            }
        }
        
        Set<Integer> set = new HashSet<>();
        for(int p: par)
            set.add(find(p));
        
        return set.size();
        
    }
    
    private void union(int i, int j){
        int parI = find(i);
        int parJ = find(j);
        
        if(parI != parJ)
            par[parJ] = parI;
    }
    
    private int find(int i){
        while(par[i] != i)
            i = par[i];
        return i;
    }
}

           


// class Solution {
//     boolean[] vis;
//     int n;
//     public int findCircleNum(int[][] edge) {
//         n = edge.length;
//         vis = new boolean[n];
//         int ans = 0;
        
//         for(int i=0; i<n; ++i){
//             if(!vis[i]){
//                 bfs(i, edge);
//                 ++ans;
//             }
//         }
        
//         return ans;
//     }
    
//     private void bfs(int i, int[][] mat){
//         Queue<Integer> q = new LinkedList<>();
//         q.offer(i);
        
//         while(!q.isEmpty()){
//             int node = q.poll();
//             vis[node] = true;
//             for(int j=0; j<n; ++j){
//                 if(mat[node][j]==1 && !vis[j])
//                     q.offer(j);
//             }
//         }
//     }
// }
              
              
// union find 1st attempt
// 
// class Solution {
//     int[] par;
//     int n;
//     public int findCircleNum(int[][] mat) {
//         n = mat.length;
//         par = new int[n];
//         Arrays.setAll(par, i->i);
        
//         for(int i=0; i<n; ++i){
//             for(int j=0; j<n; ++j){
                
//                 if(i!=j && mat[i][j]==1){
//                     int parI = find(i);
//                     int parJ = find(j);
                    
//                     if(parI != parJ)
//                         par[parJ] = parI;
//                 }
//             }
//         }
        
//         Set<Integer> set = new HashSet<>();
//         for(int p: par)
//             set.add(find(p));
        
//         return set.size();
        
//     }
    
//     private int find(int i){
//         while(par[i] != i){
//             i = par[i];
//         }
//         return i;
//     }
// }   