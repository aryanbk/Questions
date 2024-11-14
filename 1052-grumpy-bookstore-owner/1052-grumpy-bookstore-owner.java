class Solution {
    public int maxSatisfied(int[] cust, int[] grumpy, int min) {
        int n = cust.length;
        int ans = 0;
        int total = 0;
        int totalGrumpy = 0;
        int saved = 0; // max customers saved from grumpy owner
        int cur = 0;
        
        for(int i=0, j=0; j<n; ++j){
            total += cust[j];
            totalGrumpy += cust[j] * grumpy[j];
            cur += cust[j] * grumpy[j];
            while(j-i+1 > min){
                cur -= cust[i] * grumpy[i];
                ++i;
            }
            saved = Math.max(saved, cur);
        }
        
        return total - totalGrumpy + saved;
    }
}





// class Solution {
//     public int maxSatisfied(int[] cst, int[] gmp, int mnt) {
//         int n = cst.length;
//         int maxSatisfy = 0;
//         int maxUnsatisfy = 0;
        
//         for(int i=0; i<n; ++i){
//             maxSatisfy += cst[i];
//             cst[i] = cst[i]*gmp[i];
//             maxUnsatisfy += cst[i];
//         }
        
//         return maxSatisfy - maxUnsatisfy + maxSubarraySum(cst, mnt);
//     }
    
//     int maxSubarraySum(int[] nums, int k){
//         int curSumt = 0;
//         int mx = 0;
        
//         for(int l=0, r=0; r<nums.length; ++r){
//             curSumt += nums[r];
//             if(r-l+1 == k){
//                 mx = Math.max(mx, curSumt);
//                 curSumt -= nums[l];
//                 ++l;
//             }
//         }
        
//         return mx;
//     }
// }