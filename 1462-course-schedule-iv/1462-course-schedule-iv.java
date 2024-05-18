class Solution {
    List<Integer>[] map;
    Boolean[][] cache;
    
    public List<Boolean> checkIfPrerequisite(int n, int[][] pre, int[][] que) {
        cache = new Boolean[n][n];
        List<Boolean> ans = new ArrayList<>();
        
        map = new ArrayList[n];
        for(int i=0; i<n; ++i) map[i] = new ArrayList<>();
        
        for(int[] p: pre) union(p[0], p[1]);
        
        for(int[] q: que) ans.add(find(q[0], q[1]));
        
        return ans;
    }
    
    void union(int i, int j){
        map[i].add(j);
        cache[i][j] = true;
    }
    boolean find(int i, int j){
        if(i==j) return true;
        if(cache[i][j] != null) return cache[i][j];
        
        for(int nbr: map[i]){
            if(find(nbr, j)){
                cache[i][j] = true;
                return true;
            }
        }
        cache[i][j] = false;
        return false;
    }
    
}