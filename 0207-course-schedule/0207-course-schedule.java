class Solution {
    public boolean canFinish(int n, int[][] pre) {
        int[] indeg = new int[n];
        List<Integer>[] adj = new ArrayList[n];
        
        for(int i=0; i<n; ++i) adj[i] = new ArrayList<>();
        
        for(int[] e: pre){
            adj[e[0]].add(e[1]);
            ++indeg[e[1]];
        } 
        
        Queue<Integer> q = new LinkedList<>();
        int seen = 0;
        
        for(int i=0; i<n; ++i){
            if(indeg[i]==0) q.offer(i);
        }
        
        while(!q.isEmpty() && seen<n){
            int node = q.poll();
            ++seen;

            for(int nbr: adj[node]){
                --indeg[nbr];
                if(indeg[nbr]==0) q.offer(nbr);
            }
        }
        
        return seen==n;
    }
}



// // find sequence
//
// class Solution {
//     public boolean canFinish(int n, int[][] pre) {
//         Queue<Integer> q = new LinkedList<>();
//         List<Integer>[] adj = (List<Integer>[]) new List[n];
//         for (int i = 0; i < n; i++) {
//             adj[i] = new ArrayList<Integer>();
//         }

//         int[] inDeg = new int[n];
//         for(int[] p: pre){
//             adj[p[0]].add(p[1]);
//             inDeg[p[1]]+=1;
//         }
//         for(int i=0; i<n; ++i){
//             if(inDeg[i]==0)
//                 q.offer(i);
//         }
        
//         List<Integer> topo =  new ArrayList<>();
//         while(!q.isEmpty()){
//             int node = q.poll();
//             topo.add(node);
//             for(int nbr: adj[node]){
//                 inDeg[nbr]--;
//                 if(inDeg[nbr]==0)
//                     q.offer(nbr);
//             }
//         }
//         return topo.size()==n;
//     }
// }