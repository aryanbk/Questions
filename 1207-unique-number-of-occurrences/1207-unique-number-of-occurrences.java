class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        var map = new HashMap<Integer, Integer>();
        
        for(int a: arr) map.put(a, map.getOrDefault(a, 0)+1);
        
        Set<Integer> set = new HashSet<>(map.values());
        return map.values().size() == set.size();
    }
}