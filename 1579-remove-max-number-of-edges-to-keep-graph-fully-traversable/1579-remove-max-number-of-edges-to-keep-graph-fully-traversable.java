class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, (a, b) -> b[0]-a[0]);
        DSU alice = new DSU(n);
        DSU bob = new DSU(n);
        int add = 0;
        
        for(int[] e: edges){
            int type = e[0];
            int a = e[1];
            int b = e[2];
            
            
            if(type == 3){
                if(alice.union(a, b) | bob.union(a, b)) ++add;
            }
            else if(type == 1){
                if(alice.union(a, b)) ++add;
            }
            else{
                if(bob.union(a, b)) ++add;
            }
        }
        
        
        if(alice.comp!=1 || bob.comp!=1) return -1;
        return edges.length - add;
    }
}

class DSU{
    int[] map;
    int comp; // number of distict components
    
    public DSU(int n){
        map = new int[n+1];
        Arrays.setAll(map, i -> i);
        comp = n;
    }
    
    int find(int i){
        if(map[i] != i) map[i] = find(map[i]);
        return map[i];
    }
    
    boolean union(int i, int j){
        if(find(i) != find(j)){
            map[find(j)] = i;
            --comp;
            return true; // added edge
        }
        return false; // did not added edge
    }
}