class Graph {
    private List<int[]>[] adj;
    private int n;
    private int[] dist;

    // Constructor to initialize the graph with nodes and edges
    public Graph(int n, int[][] edges) {
        this.n = n;
        adj = new ArrayList[n];
        dist = new int[n];

        for (int i = 0; i < n; ++i)
            adj[i] = new ArrayList<>();

        // Add edges to the adjacency list
        for (int[] e : edges) {
            adj[e[0]].add(new int[]{e[1], e[2]});
        }
    }

    // Method to add an edge to the graph
    public void addEdge(int[] edge) {
        adj[edge[0]].add(new int[]{edge[1], edge[2]});
    }

    // Method to find the shortest path between two nodes
    public int shortestPath(int node1, int node2) {
        // Use a priority queue to store nodes with their distances, sorted by distance
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // Add the starting node with distance 0 to the priority queue
        pq.offer(new int[]{0, node1});

        // Initialize the distance array with maximum values
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Dijkstra's algorithm
        while (!pq.isEmpty()) {
            int curr = pq.peek()[0];
            int node = pq.peek()[1];
            pq.poll();

            // Skip if the current distance is greater than the recorded distance
            if (dist[node] < curr)
                continue;

            // Record the distance at the current node
            dist[node] = curr;

            // If the destination node is reached, return the distance
            if (node == node2)
                return dist[node2];

            // Explore neighbors and update distances
            for (int[] nbr : adj[node]) {
                if (dist[nbr[0]] > curr + nbr[1]) {
                    dist[nbr[0]] = curr + nbr[1];
                    pq.offer(new int[]{dist[nbr[0]], nbr[0]});
                }
            }
        }

        // If the destination node is not reachable, return -1
        return -1;
    }
}


/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */