class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n];
        List<List<Integer>> ans = new ArrayList<>();
        List<Set<Integer>> sets = new ArrayList<>();
        
        for(int i=0; i<n; ++i){
            adj[i] = new ArrayList<>();
            ans.add(new ArrayList<>());
            sets.add(new TreeSet<>());
        }
        
        int[] indeg = new int[n];
        for(int[] e: edges){
            adj[e[0]].add(e[1]);
            ++indeg[e[1]];
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; ++i){
            if(indeg[i]==0) q.add(i);
        }
        
        while(!q.isEmpty()){
            int par = q.poll();
            
            for(int child: adj[par]){
                sets.get(child).add(par);
                sets.get(child).addAll(sets.get(par));
                
                if(--indeg[child] == 0)
                    q.offer(child);
            }
        }
        
        for(int i=0; i<n; ++i)
            ans.set(i, (List.copyOf(sets.get(i))));
        return ans;
        
        
    }
}




// // // TLE
// // //
// class Solution {
//     List<Integer>[] adj;
//     List<List<Integer>> ans;
    
//     public List<List<Integer>> getAncestors(int n, int[][] edges) {
//         adj = new ArrayList[n];
        
//         for(int i=0; i<n; ++i)
//             adj[i] = new ArrayList<>();
        
//         for(int[] e: edges)
//             adj[e[1]].add(e[0]);
        
//         ans = new ArrayList<>();
//         for(int i=0; i<n; ++i)
//             ans.add(new ArrayList<Integer>());
        
//         for(int i=0; i<n; ++i){
//             if(ans.get(i).size() == 0) dfs(i);
//         }
//         return ans;
//     }

//     SortedSet<Integer> dfs(int i){
//         SortedSet<Integer> sub = new TreeSet<>();
//         for(int x=0; x<adj[i].size(); ++x){
//             int child = adj[i].get(x);
//             sub.add(child);
//             if(ans.get(child).size() != 0)
//                 sub.addAll(dfs(child));
//             else
//                 sub.addAll(ans.get(child));
//         }
//         ans.set(i, List.copyOf(sub));
//         return sub;
//     }
// }





// TLE #1
//
// class Solution {
//     List<Integer>[] adj;
//     List<List<Integer>> ans;
//     public List<List<Integer>> getAncestors(int n, int[][] edges) {
//         adj = new ArrayList[n];
//         for(int[] e: edges){
//             if(adj[e[1]] == null)
//                 adj[e[1]] = new ArrayList<>();
//             adj[e[1]].add(e[0]);
//         }
//         ans = new ArrayList<>();
//         for(int i=0; i<n; ++i){
//             SortedSet<Integer> sub = new TreeSet<>();
//             dfs(i, sub);
//             ans.add(List.copyOf(sub));
//         }
//         return ans;
//     }

//     void dfs(int i, SortedSet<Integer> sub){
//         for(int x=0; adj[i]!=null && x<adj[i].size(); ++x){
//             int child = adj[i].get(x);
//             sub.add(child);
//             if(ans.size() > child)
//                 sub.addAll(ans.get(child));
//             else
//                 dfs(child, sub);
//         }
//     }
// }