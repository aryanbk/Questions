class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> map = new TreeMap<>();
        for(int[] m: matches){
            map.put(m[0], map.getOrDefault(m[0], 0));
            map.put(m[1], map.getOrDefault(m[1], 0)+1);
        }
        
        var zero = new ArrayList<Integer>();
        var one = new ArrayList<Integer>();
        
        for(int k: map.keySet()){
            if(map.get(k)==0) zero.add(k);
            else if (map.get(k)==1) one.add(k);
        }
        
        List<List<Integer>> ans = List.of(zero, one);
        return ans;
    }
}