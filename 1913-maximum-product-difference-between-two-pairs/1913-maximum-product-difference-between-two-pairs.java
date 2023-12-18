class Solution {
    public int maxProductDifference(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return (nums[n-1]*nums[n-2]) - (nums[1]*nums[0]);
    }
}