class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums1.length;
        int ans = 0;
        
        for(int i=0; i<n; ++i){
            for(int j=0; j<n; ++j){
                int sumt = nums1[i]+nums2[j];
                map.put(sumt, map.getOrDefault(sumt, 0)+1);
            }
        }
        
        for(int i=0; i<n; ++i){
            for(int j=0; j<n; ++j){
                int sumt = nums3[i] + nums4[j];
                ans += map.getOrDefault(-sumt, 0);
            }
        }
        
        return ans;
    }
}





// // wrong approch
//
// class Solution {
//     public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
//         Arrays.sort(nums1);
//         Arrays.sort(nums2);
//         Arrays.sort(nums3);
//         Arrays.sort(nums4);
        
//         int n = nums1.length;
//         int ans = 0;
        
//         for(int i=0; i<n; ++i){
//             for(int j=0; j<n; ++j){
//                 int k = 0;
//                 int l = n-1;
//                 int target = -nums1[i]-nums2[j];
//                 while(l>=0 && k<n){
//                     if(nums3[k] + nums4[l] == target){
//                         ++ans;
//                         if(k<n-1 && nums3[k]==nums3[k+1])
//                             ++k;
//                         else
//                             --l;
//                     }
//                     else if(nums3[k] + nums4[l] > target) --l;
//                     else ++k;
//                 }
//             }
//         }
        
//         return ans;

//     }
// }