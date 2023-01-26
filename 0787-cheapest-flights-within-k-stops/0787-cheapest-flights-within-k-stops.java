class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        for(int[] f : flights){
            List<int[]> l = map.getOrDefault(f[0], new ArrayList<>());
            l.add(new int[]{f[1], f[2]});
            map.put(f[0], l);
        }
        Queue<int[]> q = new LinkedList<>();
        int[] vis = new int[n];
        Arrays.fill(vis, Integer.MAX_VALUE);
        q.offer(new int[]{0, 0, src});     // stops, curr distance, node
        
        while(!q.isEmpty()){
            int[] pop = q.poll();
            if(pop[2]==dst){
                vis[dst] = Math.min(vis[dst], pop[1]);
                continue;
            }
            if(pop[0]>k || vis[pop[2]]<pop[1]) continue;
            vis[pop[2]] = Math.min(vis[pop[2]], pop[1]);
            for(int i=0; i<map.getOrDefault(pop[2], new ArrayList<>()).size(); ++i){
                q.add(new int[]{pop[0]+1, pop[1]+map.get(pop[2]).get(i)[1], map.get(pop[2]).get(i)[0]});
                
            }
        }
        return vis[dst]!=Integer.MAX_VALUE ? vis[dst] : -1;
    }
}