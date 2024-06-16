class Solution {
    public int minPatches(int[] nums, int n) {
        long miss = 1; // long is necessary #TLE 1
        int i = 0;
        int ans = 0;
        
        while(miss <= n){
            if(i<nums.length && nums[i] <= miss){
                miss += nums[i];
                ++i;
            }
            else{
                miss += miss;
                ++ans;
            }
        }
        
        return ans;
    }
}