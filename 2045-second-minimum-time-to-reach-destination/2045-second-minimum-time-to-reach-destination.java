class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        Map<Integer, Integer> fast = new HashMap<>();
        Map<Integer, Integer> second = new HashMap<>();
        Queue<int[]> Q = new ArrayDeque<>();
        Q.offer(new int[] {1, 0});
        fast.put(1,0);
        Map<Integer, List<Integer>> G = new HashMap<>();
        int first = -1;
        
        for (int[] edge : edges) {
            if (!G.containsKey(edge[0])) {
                G.put(edge[0], new ArrayList<>());
            }
            if (!G.containsKey(edge[1])) {
                G.put(edge[1], new ArrayList<>());
            }
            G.get(edge[0]).add(edge[1]);
            G.get(edge[1]).add(edge[0]);
        }
        
        while (!Q.isEmpty()) {
            int[] p = Q.poll();
            int node = p[0];
            int currTime = p[1];
            for (Integer next : G.get(node)) {
                if (next == n) {
                    if (first == -1) {
                        first = currTime + time;
                    } else {
                        if (currTime + time > first) {
                            return currTime + time;
                        }
                    }
                }
                int targetTime = currTime + time;
                if ((targetTime / change) % 2 == 1) {
                    targetTime = (targetTime / change + 1) * change;
                }
                if (!fast.containsKey(next)) {
                    fast.put(next, targetTime);
                    Q.offer(new int[] {next, targetTime});
                    continue;
                }
                if (!second.containsKey(next) && fast.get(next) < targetTime) {
                    second.put(next, targetTime);
                    Q.offer(new int[] {next, targetTime});
                    continue;
                }
            }
        }
        return -1;
    }
}




// class Solution {
//     public int secondMinimum(int n, int[][] edges, int time, int change) {
//         List<Integer>[] adj = new ArrayList[n+1];
//         for(int i=0; i<=n; ++i) adj[i] = new ArrayList<Integer>();
//         for(int[] e: edges){
//             adj[e[0]].add(e[1]);
//             adj[e[1]].add(e[0]);
//         }
        
//         // var pq = new PriorityQueue<int[]>(Comparator.comparingInt(a->a[1]));
//         var pq = new LinkedList<int[]>();
//         pq.offer(new int[]{1, 0});
//         boolean first = true;
//         int firstTime = Integer.MAX_VALUE;
        
//         while(!pq.isEmpty()){
//             int l = pq.size();
//             for(int a=0; a<l; ++a){
//             int node = pq.peek()[0];
//             int curTime = pq.peek()[1];
//             pq.poll();
            
//             if(node == n && !first && curTime > firstTime) return curTime;
//             if(node == n && first && curTime/change % 2 == 0){
//                 first = false;
//                 firstTime = curTime;
//             }
            
//             if(curTime/change % 2 == 1){
//                 curTime += (change - (curTime%change));
//                 pq.offer(new int[]{node, curTime});
//                 continue;
//             }
            
//             for(int nbr: adj[node]){
//                 pq.offer(new int[]{nbr, curTime + time});
//             }
//             }
//         }
        
//         return -1;
//     }
// }





// class Solution {
//     public int secondMinimum(int n, int[][] edges, int time, int change) {
//         List<Integer>[] adj = new ArrayList[n+1];
//         for(int i=0; i<=n; ++i) adj[i] = new ArrayList<Integer>();
//         for(int[] e: edges){
//             adj[e[0]].add(e[1]);
//             adj[e[1]].add(e[0]);
//         }
        
//         var pq = new PriorityQueue<int[]>(Comparator.comparingInt(a->a[1]));
//         pq.offer(new int[]{1, 0});
//         boolean first = true;
//         int firstTime = Integer.MAX_VALUE;
        
//         while(!pq.isEmpty()){
//             int node = pq.peek()[0];
//             int curTime = pq.peek()[1];
//             pq.poll();
            
//             // if(node == n && !first && curTime > firstTime) return curTime;
//             // if(node == n && first && curTime/change % 2 == 0){
//                 // first = false;
//                 // firstTime = curTime;
//             // }
            
// //             if(curTime/change % 2 == 1){
// //                 curTime += (change - (curTime%change));
// //                 pq.offer(new int[]{node, curTime});
// //                 continue;
// //             }
            
//             for(int nbr: adj[node]){
//                 int newCurTime = curTime + time;
//                 if(nbr==n && !first && newCurTime>firstTime) return newCurTime;
//                 if(newCurTime/change % 2 == 1){
//                     newCurTime += (change - (newCurTime%change));
//                     pq.offer(new int[]{node, newCurTime});
//                     continue;
//                 }
//                 if(nbr==n && first){
//                     first = false;
//                     firstTime = newCurTime;
//                 }
//                 pq.offer(new int[]{nbr, newCurTime});
//             }
//         }
        
//         return -1;
//     }
// }