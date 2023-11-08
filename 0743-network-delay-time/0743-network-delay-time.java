class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] adj = new ArrayList[n+1];
        for(int i=0; i<n+1; ++i)
            adj[i] = new ArrayList<>();
        for(int[] t: times){
            adj[t[0]].add(new int[]{t[1], t[2]});
        }
        
        int[] minTime = new int[n+1];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        int maxTime = 0;
        int vis = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, k});
        
        while(!pq.isEmpty()){
            int currTime = pq.peek()[0];
            int node = pq.peek()[1];
            pq.poll();
            if(minTime[node] < currTime)
                continue;
            maxTime = currTime;
            minTime[node] = currTime;
            vis++;
            
            for(int i=0; i<adj[node].size(); ++i){
                int nbr = adj[node].get(i)[0];
                int nbrTime = currTime + adj[node].get(i)[1];
                if(minTime[nbr]>nbrTime){
                    minTime[nbr] = nbrTime;
                    pq.offer(new int[]{nbrTime, nbr});
                }
            }
        }
        System.out.println(Arrays.toString(minTime));
        return vis>=n ? maxTime : -1;
    }
}