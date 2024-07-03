class Solution {
    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        return mcm(0, 0, nums.length-1, nums);
    }
    int mcm(int x, int i, int j, int[] nums){
        if(x==3) return j>i ? Math.abs(nums[j]-nums[i]) : 0;
        return Math.min(mcm(x+1, i+1, j, nums), mcm(x+1, i, j-1, nums));
    }
}