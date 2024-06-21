class Solution {
    public int maxSatisfied(int[] cst, int[] gmp, int mnt) {
        int n = cst.length;
        int maxSatisfy = 0;
        int maxUnsatisfy = 0;
        
        for(int i=0; i<n; ++i){
            maxSatisfy += cst[i];
            cst[i] = cst[i]*gmp[i];
            maxUnsatisfy += cst[i];
        }
        
        return maxSatisfy - maxUnsatisfy + maxSubarraySum(cst, mnt);
    }
    
    int maxSubarraySum(int[] nums, int k){
        int curSumt = 0;
        int mx = 0;
        
        for(int l=0, r=0; r<nums.length; ++r){
            curSumt += nums[r];
            if(r-l+1 == k){
                mx = Math.max(mx, curSumt);
                curSumt -= nums[l];
                ++l;
            }
        }
        
        return mx;
    }
}