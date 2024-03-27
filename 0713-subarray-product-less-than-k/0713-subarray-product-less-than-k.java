class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        long prod = 1;
        int ans = 0;
        for(int l=0, r=0; r<nums.length; ++r){
            prod *= (long) nums[r];
            while(l<=r && prod>=k)
                prod /= (long)nums[l++];
            ans += r-l+1;
        }
        return ans;
    }
}