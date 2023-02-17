class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] par = new int[edges.length+1];
        for(int i=0; i<par.length; ++i)
            par[i] = i;
        
        for(int[] edge: edges){
            int findA = find(par, edge[0]), findB = find(par, edge[1]);
            if(findA != findB)
                par[findB] = par[findA];
            else
                return edge;
        }
        return edges[0];
    }
    private int find(int[] par, int i){
        while(par[i] != i)
            i = par[i];
        return i;
    }
}