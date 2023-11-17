class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int mx = -1, l = nums.length;
        for(int i=0; i<=l/2; ++i)
            mx = Math.max(mx, nums[i]+nums[l-i-1]);
        return mx;
    }
}