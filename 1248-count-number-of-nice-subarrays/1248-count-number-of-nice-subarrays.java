class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int[] nums2 = new int[nums.length];
        for(int i=0; i<nums.length; ++i)
            nums2[i] = nums[i]%2==1 ? 1 : 0;
        return subarraySum(nums2, k);
    }
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