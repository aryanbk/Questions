class Solution {
    public int mySqrt(int x) {
        int lo = 1;
        int hi = x;
        int ans = 0;
        
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(mid <= x/mid){
                lo = mid + 1;
                ans = mid;
            }
            else
                hi = mid - 1;
        }
        
        return ans;
    }
}