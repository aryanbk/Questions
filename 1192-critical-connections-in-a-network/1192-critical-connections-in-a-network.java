class Solution {
    List<List<Integer>> ans;
    List<Integer>[] graph;
    int time = 0;
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> con) {
        graph = new ArrayList[n];
        ans = new ArrayList<>();
        
        //make graph
        for(int i=0; i<n; ++i)
            graph[i] = new ArrayList<>();
        for(var c: con){
            graph[c.get(0)].add(c.get(1));
            graph[c.get(1)].add(c.get(0));
        }
        
        //
        dfs(0, -1, new boolean[n], new int[n], new int[n]);
        return ans;
    }
    
    // currentNode, parentNode, vis array, insertionTime, lowestInsertionTime
    private void dfs(int node, int par, boolean[] vis, int[] inTime, int[] lowTime){
        vis[node] = true;
        inTime[node] = lowTime[node] = time++;
        
        for(int nbr: graph[node]){
            if(nbr==par) continue;
            if(!vis[nbr]){
                dfs(nbr, node, vis, inTime, lowTime);
                lowTime[node] = Math.min(lowTime[node], lowTime[nbr]);
                if(lowTime[nbr] > inTime[node])
                    ans.add(Arrays.asList(node, nbr));
            }else{
                lowTime[node] = Math.min(lowTime[node], lowTime[nbr]);
            }
        }
    }
}