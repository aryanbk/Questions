class Solution {
    public int closestMeetingNode(int[] edge, int node1, int node2) {
        int n = edge.length;
        int[] dist1 = new int[n];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        
        var q = new LinkedList<Integer>();
        q.offer(node1);
        int curDist = 0;
        
        while(!q.isEmpty()){
            int l = q.size();
            for(int i=0; i<l; ++i){
                int node = q.poll();
                if(dist1[node] != Integer.MAX_VALUE) continue;
                dist1[node] = curDist;
                
                if(edge[node] != -1) q.offer(edge[node]);
            }
            ++curDist;
        }
        
        // 2nd BFS for node2
        q.offer(node2);
        int[] dist2 = new int[n];
        Arrays.fill(dist2, Integer.MAX_VALUE);
        curDist = 0;
        int dist = Integer.MAX_VALUE;
        int ansNode = -1;
        
        while(!q.isEmpty()){
            int l = q.size();
            for(int i=0; i<l; ++i){
                int node = q.poll();
                if(dist2[node]!=Integer.MAX_VALUE) continue;
                dist2[node] = curDist;
                
                if(edge[node] != -1) q.offer(edge[node]);
                int mxDist = Math.max(dist1[node], dist2[node]);
                if(dist > mxDist){
                    dist = mxDist;
                    ansNode = node;
                }
                else if(dist == mxDist)
                    ansNode = Math.min(ansNode, node);
            }
            
            ++curDist;
        }
        
        return ansNode;
        
    }
}