class Solution {
    public int longestSubarray(int[] nums) {
        int mx = -1;
        int curLen = 0;
        int ans = 0;
        
        for(int i=0; i<nums.length; ++i){
            if(nums[i]>mx){
                mx = nums[i];
                curLen = ans = 1;
            }
            else if(nums[i] == mx){
                ++curLen;
                ans = Math.max(ans, curLen);
            }
            else if(nums[i] < mx){
                curLen = 0;
            }
        }
        
        return ans;
    }
}