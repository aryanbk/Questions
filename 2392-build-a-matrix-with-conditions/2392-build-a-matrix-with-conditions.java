class Solution {
    public int[][] buildMatrix(int k, int[][] rowc, int[][] colc) {
        var topor = topo(rowc, k);
        var topoc = topo(colc, k);
        if(topor.size()!=k || topoc.size()!=k) return new int[][]{}; // incase of cycle
        
        var mapr = new int[k+1]; // map[element] = indexInTopo
        var mapc = new int[k+1];
        for(int i=0; i<topor.size(); ++i) mapr[topor.get(i)] = i;
        for(int i=0; i<topoc.size(); ++i) mapc[topoc.get(i)] = i;
        
        var ans = new int[k][k];
        for(int i=1; i<=k; ++i)
            ans[mapr[i]][mapc[i]] = i; //ans[indexInRowTopo][IndexInColTopo] = element
        return ans;
    }
    
    List<Integer> topo(int[][] edges, int k){
        int n = edges.length;
        int[] indeg = new int[k+1];
        
        List<Integer>[] adj = new ArrayList[k+1];
        for(int i=0; i<k+1; ++i) adj[i] = new ArrayList<Integer>();
        for(int[] e: edges){
            ++indeg[e[1]];
            adj[e[0]].add(e[1]);
        }
        
        var q = new LinkedList<Integer>();
        for(int i=1; i<=k; ++i){
            if(indeg[i]==0) q.offer(i);
        }
        
        var ans = new ArrayList<Integer>();
        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            for(var nbr: adj[node])
                if(--indeg[nbr]==0) q.offer(nbr);
        }
        
        return ans;
    }
}