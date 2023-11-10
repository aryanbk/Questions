class Solution {
    int[] ans;
    Map<Integer, List<Integer>> adj;

    public int[] restoreArray(int[][] adjacentPairs) {
        // Initialize the result array and adjacency list
        ans = new int[adjacentPairs.length + 1];
        adj = new HashMap<>();

        // Populate the adjacency list based on the input pairs
        for (int[] a : adjacentPairs) {
            adj.putIfAbsent(a[0], new ArrayList<>());
            adj.putIfAbsent(a[1], new ArrayList<>());

            adj.get(a[0]).add(a[1]);
            adj.get(a[1]).add(a[0]);
        }

        // Find a node with only one neighbor to start the reconstruction
        for (Map.Entry<Integer, List<Integer>> e : adj.entrySet()) {
            if (e.getValue().size() == 1) {
                // Start DFS from the identified node
                dfs(e.getKey(), Integer.MIN_VALUE, 0);
                // Return the reconstructed array
                return ans;
            }
        }

        return ans;
    }

    // Depth-First Search to reconstruct the array
    private void dfs(int node, int prev, int ptr) {
        // Store the current node in the result array
        ans[ptr] = node;

        // Explore neighbors
        for (int nbr : adj.get(node)) {
            // Avoid revisiting the previous node
            if (nbr != prev) {
                // Recursively explore the neighbor
                dfs(nbr, node, ptr + 1);
            }
        }
    }
}
