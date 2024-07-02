class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        var map1 = new HashMap<Integer, Integer>();
        var map2 = new HashMap<Integer, Integer>();
        for(int n: nums1)
            map1.put(n, map1.getOrDefault(n, 0)+1);
        for(int n: nums2)
            map2.put(n, map2.getOrDefault(n, 0)+1);
        
        var list = new ArrayList<Integer>();
        for(int k: map1.keySet()){
            for(int i=0; i<Math.min(map1.get(k), map2.getOrDefault(k, 0)); ++i)
                list.add(k);
        }
        
        int[] ans = new int[list.size()];
        for(int i=0; i<list.size(); ++i) ans[i] = list.get(i);
        return ans;
    }
}