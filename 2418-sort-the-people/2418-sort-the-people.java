class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        var map = new TreeMap<Integer, String>(Collections.reverseOrder());
        for(int i=0; i<names.length; ++i) map.put(heights[i], names[i]);
        
        int i=0;
        for(int h: map.keySet()){
            names[i] = map.get(h);
            ++i;
        }
        
        return names;
    }
}