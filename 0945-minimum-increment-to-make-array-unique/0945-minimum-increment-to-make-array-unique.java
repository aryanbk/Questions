class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        
        int ans = 0;
        for(int i=0, prev=-1; i<nums.length; ++i){
            if(nums[i] <= prev){
                ans += prev + 1 - nums[i];
                nums[i] = prev+1;
            }
            prev = nums[i];
        }
        
        return ans;
    }
}