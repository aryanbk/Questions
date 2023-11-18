class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int l=0, r = 0, n = nums.length;
        int ans = 1;
        int m = 0;
        while(r<n-1){
            r++;
            m += (nums[r]-nums[r-1])*(r-l);
            while(m>k && l<=r){
                m -= nums[r]-nums[l];
                l+=1;
            }
            ans = Math.max(ans, r-l+1);
        }
        return ans;
    }
}

// class Solution {
//     public int maxFrequency(int[] nums, int k) {
//         int ans = -1;
//         Map<Integer, Integer> map = new HashMap<>();
//         for(int n: nums){
//             map.put(n, map.getOrDefault(n, 0)+1);
//             ans = Math.max(ans, map.get(n));
//         }
//         return ans;
//     }
// }