class Solution {
    public boolean isZeroArray(int[] nums, int[][] que) {
        int[] line = new int[nums.length+1];
        for(int[] q: que){
            ++line[q[0]];
            --line[q[1]+1];
        }
        
        int cur = 0;
        for(int i=0; i<nums.length; ++i){
            cur += line[i];
            if(nums[i] > cur) return false;
        }
        
        return true;
    }
}