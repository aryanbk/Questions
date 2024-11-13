class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;
        long ans = 0;
        Arrays.sort(nums);
        
        for(int i=0; i<n; ++i){
            int low = lower - nums[i];
            int up = upper - nums[i];
            long lowIdx = bsLow(nums, low);
            long upIdx = bsUp(nums, up);
            
            ans += upIdx >= lowIdx ? upIdx - lowIdx + 1 : 0;
            if(lowIdx <= i && upIdx >= i) --ans;
        }
        
        return ans/2;
    }
    
    long bsLow(int[] nums, int x){
        int lo = 0;
        int hi = nums.length-1;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(nums[mid] >= x) hi = mid-1;
            else lo = mid + 1;
        }
        return lo;
    }
    
    long bsUp(int[] nums, int x){
        int lo = 0;
        int hi = nums.length - 1;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(nums[mid] <= x) lo = mid + 1;
            else hi = mid - 1;
        }
        return hi;
    }
}