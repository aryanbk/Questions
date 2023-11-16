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
                    if (adj[i][k] != Integer.MAX_VALUE && adj[k][j] != Integer.MAX_VALUE) {
                        adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                    }
                }
            }
        }

        int minCities = n + 1;
        int city = -1;

        for (int i = 0; i < n; ++i) {
            int reachableCities = 0;

            for (int j = 0; j < n; ++j) {
                if (adj[i][j] <= maxDis) {
                    reachableCities++;
                }
            }

            if (reachableCities <= minCities) {
                minCities = reachableCities;
                city = i;
            }
        }

        return city;
    }
}



// class Solution {
//     public int findTheCity(int n, int[][] edges, int maxDis) {
//         int[][] adj = new int[n][n];
        
//         for(int[] a: adj)
//             Arrays.fill(a, Integer.MAX_VALUE);
        
//         for(int[] e: edges)
//             adj[e[0]][e[1]] = adj[e[1]][e[0]] = e[2];
        
//         for(int i=0; i<n; ++i)
//             adj[i][i] = 0; 
//         // for(int[] a: adj)
//             // System.out.println(Arrays.toString(a));

//         for(int i=0; i<n; ++i){ //via
//             int[][] temp = new int[n][n];
//             for(int j=0; j<n; ++j){ //from
//                 for(int k=0; k<n; ++k){ //to
//                     long via = (long)adj[j][i] + (long)adj[i][k];
//                     if(via > (long)Integer.MAX_VALUE)
//                         continue;
//                     temp[j][k] = Math.min(adj[j][k], (int)via);
//                 }
//             }
//             adj = temp;
//         }
        
        // for(int[] a: adj)
        //     System.out.println(Arrays.toString(a));
        
//         int reach = n+1;
//         int city = n+1;
//         for(int i=0; i<n; ++i){
//             int near = 0;
//             for(int j=0; j<n; ++j){
//                 if(adj[i][j] < maxDis){
//                     ++near;
//                 }
//             }
//             if(near<=reach){
//                 reach = near;
//                 city=i;
//             }
//         }
//         return city;
//     }
// }



// class Solution {


// // [0, 3, 4, 5]
// // [3, 0, 1, 2]
// // [4, 1, 0, 1]
// // [5, 2, 1, 0]
// // [0, 2, 5, 5, 4]
// // [2, 0, 3, 3, 2]
// // [5, 3, 0, 1, 2]
// // [5, 3, 1, 0, 1]
// // [4, 2, 2, 1, 0]
    
//     public int findTheCity(int n, int[][] edges, int maxDis) {
//         int[][] adj = new int[n][n];
        
//         for(int[] a: adj)
//             Arrays.fill(a, Integer.MAX_VALUE);
//             // Arrays.fill(a, 10002);
        
//         for(int[] e: edges)
//             adj[e[0]][e[1]] = adj[e[1]][e[0]] = e[2];

        
//         for(int i=0; i<n; ++i)
//             adj[i][i] = 0; 
//         // for(int[] a: adj)
//             // System.out.println(Arrays.toString(a));

//         for(int i=0; i<n; ++i){ //via
//             int[][] temp = new int[n][n];
//             for(int j=0; j<n; ++j){ //from
//                 for(int k=0; k<n; ++k){ //to
//                     if(adj[j][i] != Integer.MAX_VALUE && adj[i][j] != Integer.MAX_VALUE)
//                         temp[j][k] = Math.min(adj[j][k], adj[j][i]+adj[i][k]);
//                 }
//             }
//             adj = temp;
//         }
        
//         for(int[] a: adj)
//             System.out.println(Arrays.toString(a));
        
//         int reach = n+1;
//         int city = n+1;
//         for(int i=0; i<n; ++i){
//             int near = 0;
//             for(int j=0; j<n; ++j){
//                 if(adj[i][j] < maxDis){
//                     ++near;
//                 }
//             }
//             if(near<=reach){
//                 reach = near;
//                 city=i;
//             }
//         }
//         return city;
//     }
// }