class Solution {
    public int removeStones(int[][] stones) {
        Map<Integer, Set<Integer>> rSet = new HashMap<>(), cSet = new HashMap<>();
        for(int[] e : stones) {
            int r = e[0], c = e[1];
            rSet.putIfAbsent(r, new HashSet<>());
            cSet.putIfAbsent(c, new HashSet<>());
            rSet.get(r).add(c);
            cSet.get(c).add(r);
        }
        
        int count = 0;
        Set<String> v = new HashSet<>();
        for(int[] e : stones) {
            String key = e[0]+","+e[1];
            if(!v.contains(key)) {
                count++;
                v.add(key);
                dfs(e[0], e[1], rSet, cSet, v);
            }
        }
        return stones.length - count;
    }
    
    void dfs(int r, int c, Map<Integer, Set<Integer>> rSet, Map<Integer, Set<Integer>> cSet, Set<String> v) {
        for(int y : rSet.get(r)) {
            String key = r+","+y;
            if(!v.contains(key)) {
                v.add(key);
                dfs(r, y, rSet, cSet, v);
            }
        }
        
        for(int x : cSet.get(c)) {
            String key = x+","+c;
            if(!v.contains(key)) {
                v.add(key);
                dfs(x, c, rSet, cSet, v);
            }
        }        
    }
}