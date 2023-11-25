class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int sumt = 0;
        for(int a: nums) sumt += a;
        
        int currSumt = 0;
        int[] ans = new int[n];
        
        for(int i=0; i<n; ++i){
            int rightSumt = sumt - currSumt - (n-i)*nums[i];
            int leftSumt = i*nums[i] - currSumt;
            ans[i] =  +  rightSumt + leftSumt;

            currSumt += nums[i];
        }
        return ans;
    }
}