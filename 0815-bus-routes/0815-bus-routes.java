class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        // If source and target are the same, no buses needed.
        if (source == target)
            return 0;

        // Create a graph to represent bus routes and their stops.
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        // Populate the graph.
        for (int i = 0; i < routes.length; ++i) {
            for (int j = 0; j < routes[i].length; ++j) {
                adj.putIfAbsent(routes[i][j], new ArrayList<>());
                adj.get(routes[i][j]).add(i);
            }
        }

        // Use a queue for BFS traversal.
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        int ans = 0;

        // Set to keep track of visited buses to avoid redundant traversal.
        Set<Integer> visBus = new HashSet();

        // Perform BFS.
        while (!q.isEmpty()) {
            int l = q.size();
            ans++;

            // Traverse the current level of stops.
            for (int i = 0; i < l; ++i) {
                int node = q.poll();
                List<Integer> buses = adj.get(node);

                // Traverse buses that pass through the current stop.
                for (int bus : buses) {
                    if (visBus.contains(bus))
                        continue;
                    visBus.add(bus);

                    // Check  stop of the current bus.
                    for (int newNode: routes[bus]) {
                        // If the target stop is reached, return the answer.
                        if (newNode == target)
                            return ans;
                        q.offer(newNode);
                    }
                }
            }
        }

        // If target cannot be reached by any bus, return -1.
        return -1;
    }
}


// wrong code
// https://onlinegdb.com/b_DCOwFJq