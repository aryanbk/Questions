class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans=0;
        long sumt=0;
        HashMap<Long, Integer> map = new HashMap<>();
        map.put((long)0, 1);
        for(int n: nums){
            sumt+=n;
            ans+=map.getOrDefault(sumt-k, 0);
            map.put(sumt, map.getOrDefault(sumt, 0)+1);
        }
        return ans;
    }
}
