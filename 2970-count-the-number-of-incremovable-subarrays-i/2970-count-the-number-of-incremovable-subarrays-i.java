class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        int[] incr = new int[n];
        
        for(int i=1; i<n; ++i){
            if(nums[i-1] < nums[i])
                incr[i] = incr[i-1];
            else
                incr[i] = i;
        }
        
        int ans = 0;
        
        for(int i=0; i<n; ++i){
            for(int j=i; j<n; ++j){
                if(isValid(i, j, n, nums, incr))
                    ++ans;
            }
        }
        
        return ans;
    }
    
    boolean isValid(int i, int j, int n, int[] nums, int[] incr){
        return (i==0 || incr[i-1]==0) && (incr[n-1] <= j+1) && 
                   (i==0 || j==n-1 || nums[i-1] < nums[j+1]);
    }
}