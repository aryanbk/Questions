class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sumt = 0;
        int mx = 0;
        for(int w: weights){
            sumt += w;
            mx = Math.max(w, mx);
        }
        
        int lo = mx;
        int hi = sumt;
        
        int ans = -1;
        while(lo <= hi){
            int mid = (hi - lo)/2 + lo;
            if(valid(weights, days, mid)){
                ans = mid;
                hi = mid - 1;
            }
            else
                lo = mid + 1;
        }
        
        return ans;
    }
    boolean valid(int[] w, int days, int cap){
        int cur = 0;
        for(int i=0; i<w.length; ++i){
            if(cur + w[i] <= cap) cur += w[i];
            else{
                --days;
                cur = w[i];
            }
        }
        return days>0;
    }
}





// class Solution {
//     public int shipWithinDays(int[] weights, int days) {
//         int sumt=0, maxi=0;
//         for(int w: weights){
//             sumt+=w;
//             maxi = Math.max(maxi, w);
//         }
//         int lo=maxi, hi=sumt, res=-1;
//         while(lo<=hi){
//             int mid = lo + (hi-lo)/2;
//             if(valid(mid, weights, days)){
//                 res = mid;
//                 hi = mid-1;
//             }else
//                 lo = mid+1;
//         }
//         return res;
//     }
//     private boolean valid(int c, int[] w, int d){
//         int curr=0;
//         for(int i=0; i<w.length; ++i){
//             curr+=w[i];
//             if(curr>c){
//                 d-=1;
//                 curr = w[i];
//             }
//         }
//         return d-1>=0;
//     }
// }