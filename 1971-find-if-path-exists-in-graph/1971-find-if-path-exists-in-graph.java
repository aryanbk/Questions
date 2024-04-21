class Solution {
    List<Integer>[] adj;
    public boolean validPath(int n, int[][] edges, int src, int des) {
        adj = new ArrayList[n];
        for(int i=0; i<n; ++i) adj[i] = new ArrayList<>();
        for(int[] e: edges){
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        return dfs(src, des, new HashSet<>());
    }
    
    boolean dfs(int src, int des, Set<Integer> set){
        if(src == des) return true;
        set.add(src);
        for(int nbr: adj[src]){
            if(!set.contains(nbr) && dfs(nbr, des, set)) return true;
        }
        return false;
    }
}


// class Solution {
//     public boolean validPath(int n, int[][] edges, int start, int end) {
//         Map<Integer, List<Integer>> g = new HashMap<>();
//         IntStream.range(0, n).forEach(u -> g.put(u, new ArrayList<>()));
//         for (int[] e : edges) {
//             g.get(e[0]).add(e[1]);
//             g.get(e[1]).add(e[0]);
//         }
//         Set<Integer> seen = new HashSet<>();
//         Queue<Integer> q = new LinkedList<>();
//         for (q.add(start), seen.add(start); !q.isEmpty(); )
//             if (q.peek() == end)
//                 return true;
//             else g.get(q.poll()).stream().filter(seen::add).forEach(q::offer);
//         return false;
//     }
// }