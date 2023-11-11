class Graph {
    private List<int[]>[] adj;
    private int n;
    // private int[] dist;
    public Graph(int n, int[][] edges) {
        this.n = n;
        adj = new ArrayList[n];
        // dist = new int[n];
        
        // for(List<int[]> l: adj)
            // l = new ArrayList<>();
        for(int i=0; i<n; ++i)
            adj[i] = new ArrayList<>();
        for(int[] e: edges){
            adj[e[0]].add(new int[]{e[1], e[2]});
        }
    }
    
    public void addEdge(int[] edge) {
        adj[edge[0]].add(new int[]{edge[1], edge[2]});
    }
    
    public int shortestPath(int node1, int node2) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        pq.offer(new int[]{0, node1});
        
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        while(!pq.isEmpty()){
            int curr = pq.peek()[0];
            int node = pq.peek()[1];
            pq.poll();
            
            if(dist[node] < curr)
                continue;
            dist[node] = curr;
            if(node==node2)
                return dist[node2];
            for(int[] nbr: adj[node]){
                if(dist[nbr[0]] > curr+nbr[1]){
                    dist[nbr[0]] = curr+nbr[1];
                    pq.offer(new int[]{dist[nbr[0]], nbr[0]});
                }
            }
        }
        return -1;
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */