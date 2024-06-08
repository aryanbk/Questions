class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int m = nums1.length;
        int n = nums2.length;
        long ans = 0;
        
        for(int i=0; i<n; ++i)
            map.put(nums2[i], map.getOrDefault(nums2[i], 0)+1);
        
        for(int i=0; i<m; ++i){
            if(nums1[i] % k == 0){
                int num = nums1[i]/k;
                for(int j=1; j*j <= num; ++j)
                    if(num % j == 0){
                        ans += map.getOrDefault(j, 0);
                        int op = num/j;
                        ans += j!=op ? map.getOrDefault(op, 0) : 0;
                    }
            }
        }
        
        return ans;
    }
}





// class Solution {
//     public long numberOfPairs(int[] nums1, int[] nums2, int k) {
//         Map<Integer, Integer> map = new HashMap<>();
//         int m = nums1.length;
//         int n = nums2.length;
//         long ans = 0;
        
//         for(int i=0; i<n; ++i)
//             map.put(nums2[i]*k, map.getOrDefault(nums2[i]*k, 0)+1);
        
//         for(int i=0; i<m; ++i){
//             for(int j=1; j*j<=nums1[i]; ++j)
//                 if(nums1[i]%j == 0){
//                     ans += map.getOrDefault(j, 0);
//                     int op = nums1[i]/j;
//                     ans += j!=op ? map.getOrDefault(op, 0) : 0;
//                 }
//         }
        
//         return ans;
//     }
// }