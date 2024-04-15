class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        long ans = 0;
        for(int l=0, r=0; r<nums.length; ++r){
            if(r>0 && nums[r]==nums[r-1]) l=r;
            ans += (long) (r-l+1);
        }
        return ans;
    }
}