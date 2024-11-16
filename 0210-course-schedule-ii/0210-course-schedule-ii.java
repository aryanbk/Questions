class Solution {
    public int[] findOrder(int n, int[][] pre) {
        Queue<Integer> q = new LinkedList<>();
        
        List<Integer>[] adj = (List<Integer>[]) new List[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<Integer>();

        int[] inDeg = new int[n];
        for(int[] p: pre){
            adj[p[1]].add(p[0]);
            ++inDeg[p[0]];
        }
        
        for(int i=0; i<n; ++i){
            if(inDeg[i]==0)
                q.offer(i);
        }
        
        int[] topo = new int[n];
        int ptr=0;
        
        while(!q.isEmpty()){
            int node = q.poll();
            topo[ptr++]=node;
            
            for(int nbr: adj[node]){
                --inDeg[nbr];
                if(inDeg[nbr]==0)
                    q.offer(nbr);
            }
        }
        return ptr==n ? topo : new int[0];
        
    }
}