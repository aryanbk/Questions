class Solution {
    public int findMaxLength(int[] nums) {
        int sumt = 0;
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i=0; i<nums.length; ++i){
            sumt += nums[i]==1 ? 1 : -1;
            if(map.containsKey(sumt)) ans = Math.max(ans, i-map.get(sumt));
            else map.put(sumt, i);
        }
        return ans;
    }
}