class Solution {
    public int lengthOfLIS(int[] nums) {
        int l = 1;
        for(int i=1; i<nums.length; ++i){
            if(nums[l-1] < nums[i]){
                nums[l] = nums[i];
                ++l;
            }
            else{
                int idx = Arrays.binarySearch(nums, 0, l, nums[i]);
                if(idx < 0) idx = (idx*-1) - 1;
                nums[idx] = nums[i];
            }
        }
        return l;
    }
}


