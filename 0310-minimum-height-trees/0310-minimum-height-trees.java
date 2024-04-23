class Solution {
    List<Integer>[] map;
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        map = new ArrayList[n];
        for(int i=0; i<n; ++i) map[i] = new ArrayList<>();
        
        int mx = 0;
        int mxOut = 0;
        int mxNode = -1;
        for(int[] e: edges){
            map[e[0]].add(e[1]);
            map[e[1]].add(e[0]);
            mx = Math.max(mx, Math.max(map[e[0]].size(), map[e[1]].size()));
        }
        
        List<Integer> path = longestPath(longestPath(0, -1).get(0), -1);
        int size = path.size();
        if(size%2==1) return List.of(path.get(size/2));
        return List.of(path.get((size-1)/2), path.get(size/2));
        
    }
    List<Integer> longestPath(int i, int p){
        List<Integer> ans = new ArrayList<>();
        for(int x: map[i]){
            if(x != p){
                List<Integer> xl = longestPath(x, i);
                if(xl.size() > ans.size())
                    ans = xl;
            }
        }
        ans.add(i);
        return ans;
    }
}

// // won't work
// // wrong approch
//
// class Solution {
//     List<Integer>[] map;
    
//     public List<Integer> findMinHeightTrees(int n, int[][] edges) {
//         map = new ArrayList[n];
//         for(int i=0; i<n; ++i) map[i] = new ArrayList<>();
        
//         int mx = 0;
//         int mxOut = 0;
//         int mxNode = -1;
//         for(int[] e: edges){
//             map[e[0]].add(e[1]);
//             map[e[1]].add(e[0]);
//             mx = Math.max(mx, Math.max(map[e[0]].size(), map[e[1]].size()));
//         }
//         int node = -1;
//         int mxH = 100000000;
//         for(int i=0; i<n; ++i){
//             if(map[i].size()==mx){
//                 int h = height(i);
//                 if(h < mxH){
//                     mxh = h;
//                     node = i;
//                 }
//             }
//         }
//         return dfs(node);
        
//     }
    
//     int height(int node, int par){
//         int ans = 0;
//         for(int nbr: map[node]){
//             if(nbr != par){
//                 ans = Math.max(ans, height(nbr));
//             }
//         }
//         return ans+1;
//     }

//     List<Integer> dfs(int node, int par){
//         if(map[node].size()==1 && map[node].get(0)==par)
//             return new ArrayList<>();
//         List<Integer> ans = new ArrayList<>();
//         for(int nbr: map[node]){
//             if(nbr != par){
//                 Set<Integer> x = dfs(nbr, node);
//                 if(x.size() > ans.size())
//                     ans = x;
//                 else if(x.size() == ans.size())
//                     ans = Sets.union(ans, x);
//             }
//         }
//         return ans;
//     }
    
//     // Set<Integer> dfs(int node, int par){
//     //     if(map[node].size()==1 && map[node].get(0)==par)
//     //         return new HashSet<>();
//     //     Set<Integer> ans = new HashSet<>();
//     //     for(int nbr: map[node]){
//     //         if(nbr != par){
//     //             Set<Integer> x = dfs(nbr, node);
//     //             if(x.size() > ans.size())
//     //                 ans = x;
//     //             else if(x.size() == ans.size())
//     //                 ans = Sets.union(ans, x);
//     //         }
//     //     }
//     //     return ans;
//     // }
// }