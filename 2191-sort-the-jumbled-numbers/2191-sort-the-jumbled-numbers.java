class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        var idx = new Integer[nums.length];
        Arrays.setAll(idx, (i)->i);
        // sort indexed based on value after mapping
        Arrays.sort(idx, (a, b) -> find(nums[a], mapping) - find(nums[b], mapping));
        var ans = new int[nums.length];
        for(int i=0; i<nums.length; ++i) ans[i] = nums[idx[i]];
        return ans;
    }
    
    // to find value of number after applying mapping
    int find(int n, int[] mapping){
        String num = Integer.toString(n);
        int ans = 0;
        for(int i=0; i<num.length(); ++i){
            int cur = num.charAt(i)-'0';
            ans = (ans*10)+mapping[cur];
        }
        return ans;
    }
}

// class Solution {
//     public int[] sortJumbled(int[] mapping, int[] nums) {
//         Integer[] nums2 = new Integer[nums.length];
//         for(int i=0; i<nums.length; ++i)
//             nums2[i] = nums[i];
//         var map = new HashMap<Integer, Integer>();
//         for(int n: nums) map.putIfAbsent(n, val(n, mapping));
//         Arrays.sort(nums2, (a, b) -> map.get(a)-map.get(b));
//         for(int i=0; i<nums.length; ++i) nums[i] = nums2[i];
//         return nums;
        
//     }
    
//     int val(int n, int[] mapping){
//         String num = Integer.toString(n);
//         int ans = 0;
//         for(int i=0; i<num.length(); ++i){
//             int cur = num.charAt(i)-'0';
//             ans = (ans*10)+mapping[cur];
//         }
//         return ans;
//     }
// }