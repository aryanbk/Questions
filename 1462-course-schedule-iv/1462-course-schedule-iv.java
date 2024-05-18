class Solution {
    List<Integer>[] map;
    // Map<List<Integer>, Boolean> cache;
    Boolean[][] cache;
    public List<Boolean> checkIfPrerequisite(int n, int[][] pre, int[][] q) {
        map = new ArrayList[n];
        // cache = new HashMap<>();
        cache = new Boolean[n][n];
        
        Arrays.setAll(map, (i) -> {
            List<Integer> list = new ArrayList<>();
            // list.add(i);
            return list;
        });
        for(int[] p: pre)
            union(p[0], p[1]);
        
        List<Boolean> ans = new ArrayList<>();
        for(int[] i: q){
            ans.add(find(i[0], i[1]));
        }
        return ans;
    }
    
    void union(int i, int j){
        map[i].add(j);
    }
    boolean find(int i, int j){
        // if()
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