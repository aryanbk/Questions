class Solution {
    public double maxProbability(int n, int[][] edge, double[] prob, int start_node, int end_node) {
        List<Pair>[] adj = new ArrayList[n];
        for(int i=0; i<n; ++i)
            adj[i] = new ArrayList<>();
        for(int i=0; i<edge.length; ++i){
            adj[edge[i][0]].add(new Pair(edge[i][1], prob[i]));
            adj[edge[i][1]].add(new Pair(edge[i][0], prob[i]));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(new pCompare());
        pq.offer(new Pair(start_node, 1.0));
        double[] maxProb = new double[n];
        
        while(!pq.isEmpty()){
            int node = pq.peek().node;
            double p = pq.peek().p;
            pq.poll();
            if(maxProb[node]>p)
                continue;
            for(Pair nbr: adj[node]){
                double newProb = nbr.p*p;
                if(maxProb[nbr.node] < newProb){
                    maxProb[nbr.node] = newProb;
                    pq.offer(new Pair(nbr.node, newProb));
                }
            }
        }
        return maxProb[end_node];
    }
    
}

class Pair{
    int node;
    double p;
    public Pair(int _node, double _p){
        node = _node;
        p = _p;
    }
}

class pCompare implements Comparator<Pair>{
    @Override
    public int compare(Pair pair1, Pair pair2){
        if(pair1.p==pair2.p)
            return 0;
        return pair1.p - pair2.p >0 ? -1 : 1;
    }
}