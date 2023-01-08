class Solution {
    public int maxSubArray(int[] nums) {
        long curr=0, ans=0;
        int maxNegative=Integer.MIN_VALUE;
        for(int i=0; i<nums.length; ++i){
            curr += nums[i];
            if(nums[i]<=0) maxNegative=Math.max(maxNegative, nums[i]);
            if(curr<0) curr=0;
            ans=Math.max(ans, curr);
        }
        return ans==0 ? maxNegative : (int)ans;
    }
}