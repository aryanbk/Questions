// topo sort - DFS

class Solution {
    List<Integer>[] adj;
    boolean[] vis;
    Stack<Integer> stk;
    int[] indeg;
    
    public int[] findOrder(int n, int[][] pre) {
        adj = new ArrayList[n];
        vis = new boolean[n];
        stk = new Stack<>();
        indeg = new int[n];
        
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<Integer>();
        for(int[] p: pre){
            adj[p[1]].add(p[0]);
            ++indeg[p[0]];
        }
        
        for(int i=0; i<n; ++i){
            if(indeg[i]==0) topo(i);
        }
        
        if(stk.size()!=n) return new int[0];
            
        int[] ans = new int[n];
        for(int i=n-1; i>=0; --i) ans[i] = stk.pop();
        return ans;
    }
    
    void topo(int node){
        stk.push(node);
        indeg[node] = -1;
        // if(vis[node]) return;
        // vis[node] = true;
        
        for(int nbr: adj[node]){
            --indeg[nbr];
            if(indeg[nbr]==0) topo(nbr);
        }
        
        // stk.push(node);
    }
    
}



// // topo - bfs
//
// class Solution {
//     public int[] findOrder(int n, int[][] pre) {
//         Queue<Integer> q = new LinkedList<>();
        
//         List<Integer>[] adj = (List<Integer>[]) new List[n];
//         for (int i = 0; i < n; i++)
//             adj[i] = new ArrayList<Integer>();

//         int[] inDeg = new int[n];
//         for(int[] p: pre){
//             adj[p[1]].add(p[0]);
//             ++inDeg[p[0]];
//         }
        
//         for(int i=0; i<n; ++i){
//             if(inDeg[i]==0)
//                 q.offer(i);
//         }
        
//         int[] topo = new int[n];
//         int ptr=0;
        
//         while(!q.isEmpty()){
//             int node = q.poll();
//             topo[ptr++]=node;
            
//             for(int nbr: adj[node]){
//                 --inDeg[nbr];
//                 if(inDeg[nbr]==0)
//                     q.offer(nbr);
//             }
//         }
//         return ptr==n ? topo : new int[0];
        
//     }
// }