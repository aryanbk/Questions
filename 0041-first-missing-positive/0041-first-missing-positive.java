class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int ptr = 1;
        for(int i=0; i<nums.length && nums[i]<=ptr; ++i){
            if(nums[i]==ptr) ++ptr;
        }
        return ptr;
    }
}