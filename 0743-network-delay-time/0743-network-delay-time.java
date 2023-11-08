class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // array of list of arrays to store adj list
        List<int[]>[] adj = new ArrayList[n+1];
        
        // initializing every element with new ArrayList<>();
        for(int i=0; i<n+1; ++i)
            adj[i] = new ArrayList<>();
        // add adj nodes with delay time
        for(int[] t: times)
            adj[t[0]].add(new int[]{t[1], t[2]});
        
        // minTime will store minTime to reach a node
        // it'll also work as 
        int[] minTime = new int[n+1];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        
        // we will keep of maxTime at every node
        // so we don't have to reiterate over minTime at the end
        int maxTime = 0;
        // vis will keep track of no. of visited node
        // if vis != n then all nodes are not reachable
        int vis = 0;
        
        // keep in mind pq syntax for arrays
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, k});
        
        while(!pq.isEmpty()){
            int currTime = pq.peek()[0];
            int node = pq.peek()[1];
            pq.poll();
            
            if(minTime[node] < currTime)
                continue;
            
            minTime[node] = currTime;
            maxTime = currTime;
            vis++;
            
            // Iterate over neighboring nodes and update their times.
            for (int[] nbr : adj[node]) {
                int nbrNode = nbr[0];
                int nbrTime = currTime + nbr[1];

                if (nbrTime < minTime[nbrNode]) {
                    minTime[nbrNode] = nbrTime;
                    pq.offer(new int[]{nbrTime, nbrNode});
                }
            }
        }
        
        return vis>=n ? maxTime : -1;
    }
}