class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        return back(0, new HashMap<>(), k, nums);
    }
    
    int back(int i, Map<Integer, Integer> map, int k, int[] nums){
        if(i == nums.length) 
            return map.size() > 0 ? 1 : 0;
        
        int ans = back(i+1, map, k, nums);
        
        if(map.getOrDefault(nums[i]-k, 0) == 0 && map.getOrDefault(nums[i]+k, 0) == 0){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            ans += back(i+1, map, k, nums);
            map.put(nums[i], map.get(nums[i]) - 1);
        }
        
        return ans;
    }
}