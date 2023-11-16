class Solution {
    public int findTheCity(int n, int[][] edges, int maxDis) {
        // Create adjacency matrix
        int[][] adj = new int[n][n];
        for (int[] a : adj)
            Arrays.fill(a, Integer.MAX_VALUE);

        for (int[] e : edges)
            adj[e[0]][e[1]] = adj[e[1]][e[0]] = e[2];

        // Apply Floyd-Warshall
        for (int i = 0; i < n; ++i)
            adj[i][i] = 0;

        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (adj[i][k] != Integer.MAX_VALUE && adj[k][j] != Integer.MAX_VALUE)
                        adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                }
            }
        }

        int minCities = n + 1;
        int city = -1;

        for (int i = 0; i < n; ++i) {
            int reachableCities = 0;

            for (int j = 0; j < n; ++j)
                if (adj[i][j] <= maxDis)
                    reachableCities++;

            if (reachableCities <= minCities) {
                minCities = reachableCities;
                city = i;
            }
        }

        return city;
    }
}



// wrong code
// https://onlinegdb.com/SC43uNiHp