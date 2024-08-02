class Solution {
    public int minSwaps(int[] nums) {
        int totalOnes = 0;
        for(int i=0; i<nums.length; ++i) totalOnes += nums[i];
        
        if(totalOnes==0 || totalOnes==nums.length) return 0;
        int ans = 1000000000;
        int windowOnes = 0;
        
        for(int l=0, r=0; l<nums.length; ++r){
            windowOnes += nums[r%nums.length];
            if(r-l+1 == totalOnes){
                ans = Math.min(ans, totalOnes-windowOnes);
                windowOnes -= nums[l];
                ++l;
            }
        }
        
        return ans;
    }
}