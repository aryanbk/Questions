class Solution {
    public int countKDifference(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums) map.put(n, map.getOrDefault(n, 0)+1);
        
        int ans = 0;
        for(var e: map.entrySet()){
            int key = e.getKey();
            int val = e.getValue();
            
            ans += (val * map.getOrDefault(key-k, 0));
        }
        
        return ans;
    }
}