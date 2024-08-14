class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int lo = 0;
        int hi = nums[n-1];
        int ans = -1;
        
        while(lo<hi){
            int mid = lo + (hi-lo)/2;
            int midsPosition = solve(nums, mid);
            if(midsPosition >= k) hi = mid;
            else lo = mid + 1;
        }
        
        return lo;
    }
    
    int solve(int[] nums, int diff){
        int diffsPosition = 0;
        for(int l=0, r=1; r<nums.length && l<r; ++r){
            while(nums[r]-nums[l] > diff) ++l;
            diffsPosition += r-l;
        }
        return diffsPosition;
    }
}