class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int sumt = 0;
        int ans = 0;
        
        int[] map = new int[k];
        map[0]=1;
        
        for(int i=0; i<n; ++i){
            sumt += nums[i];
            int mod = (sumt % k);
            mod = mod>=0 ? mod : k+mod;
            ans += map[mod];
            ++map[mod];
        }
        
        return ans;
    }
}





// class Solution {
//     public int subarraysDivByK(int[] nums, int k) {
//         int n = nums.length;
//         int sumt = 0;
//         int ans = 0;
        
//         Map<Integer, Integer> map = new HashMap<>();
//         map.put(0, 1);
        
//         for(int i=0; i<n; ++i){
//             sumt += nums[i];
//             int mod = sumt % k;
//             mod = mod<0 ? k+mod : mod;
//             ans += map.getOrDefault(mod, 0);
//             map.put(mod, map.getOrDefault(mod, 0)+1);
//         }
        
//         return ans;
//     }
// }




// class Solution {
//     public int subarraysDivByK(int[] nums, int k) {
//         int n = nums.length;
//         int sumt = 0;
//         int ans = 0;
        
        
//         List<Integer>[] map = new ArrayList[k];
//         for(int i=0; i<k; ++i)
//             map[i] = new ArrayList<>();
//         map[0].add(-1);
        
//         for(int i=0; i<n; ++i){
//             sumt += nums[i];
//             int mod = sumt%k;
//             ans += map[mod].size();
//             map[mod].add(i);
//         }
        
//         return ans;
//     }
// }