class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // Create an adjacency list to represent the graph
        List<Pair>[] adj = new ArrayList[n];
        for (int i = 0; i < n; ++i)
            adj[i] = new ArrayList<>();
        
        // Populate the adjacency list based on edge probabilities
        for (int i = 0; i < edges.length; ++i) {
            int from = edges[i][0];
            int to = edges[i][1];
            double probability = succProb[i];
            adj[from].add(new Pair(to, probability));
            adj[to].add(new Pair(from, probability)); // Undirected graph
        }

        // Use a priority queue to explore paths with higher probabilities first
        PriorityQueue<Pair> pq = new PriorityQueue<>(new ProbabilityComparator());
        pq.offer(new Pair(start, 1.0)); // Starting node with probability 1.0
        double[] maxProbability = new double[n];
        
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int currentNode = current.node;
            double currentProbability = current.p;
            
            // If we have already explored a path with higher probability, skip
            if (maxProbability[currentNode] > currentProbability)
                continue;

            // Explore neighbors and update probabilities
            for (Pair neighbor : adj[currentNode]) {
                double newProbability = neighbor.p * currentProbability;
                if (maxProbability[neighbor.node] < newProbability) {
                    maxProbability[neighbor.node] = newProbability;
                    pq.offer(new Pair(neighbor.node, newProbability));
                }
            }
        }
        
        return maxProbability[end];
    }
}

class Pair {
    int node;
    double p;   
    public Pair(int _node, double _p) {
        node = _node;
        p = _p;
    }
}
class ProbabilityComparator implements Comparator<Pair> {
    @Override
    public int compare(Pair pair1, Pair pair2) {
        // Compare probabilities in descending order
        return Double.compare(pair2.p, pair1.p);
    }
}




// class Solution {
//     public double maxProbability(int n, int[][] edge, double[] prob, int start_node, int end_node) {
//         List<Pair>[] adj = new ArrayList[n];
//         for(int i=0; i<n; ++i)
//             adj[i] = new ArrayList<>();
//         for(int i=0; i<edge.length; ++i){
//             adj[edge[i][0]].add(new Pair(edge[i][1], prob[i]));
//             adj[edge[i][1]].add(new Pair(edge[i][0], prob[i]));
//         }
        
//         PriorityQueue<Pair> pq = new PriorityQueue<>(new pCompare());
//         pq.offer(new Pair(start_node, 1.0));
//         double[] maxProb = new double[n];
        
//         while(!pq.isEmpty()){
//             int node = pq.peek().node;
//             double p = pq.peek().p;
//             pq.poll();
//             if(maxProb[node]>p)
//                 continue;
//             for(Pair nbr: adj[node]){
//                 double newProb = nbr.p*p;
//                 if(maxProb[nbr.node] < newProb){
//                     maxProb[nbr.node] = newProb;
//                     pq.offer(new Pair(nbr.node, newProb));
//                 }
//             }
//         }
//         return maxProb[end_node];
//     }
    
// }

// class Pair{
//     int node;
//     double p;
//     public Pair(int _node, double _p){
//         node = _node;
//         p = _p;
//     }
// }

// class pCompare implements Comparator<Pair>{
//     @Override
//     public int compare(Pair pair1, Pair pair2){
//         if(pair1.p==pair2.p)
//             return 0;
//         return pair1.p - pair2.p >0 ? -1 : 1;
//     }
// }