class Solution {
    public long largestPerimeter(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        long sumt = nums[0]+nums[1];
        long ans = -1;
        for(int i=2; i<n; ++i){
            if(sumt > nums[i]) ans = Math.max(ans, sumt+nums[i]);
            sumt += nums[i];
        }
        return ans;
    }
}