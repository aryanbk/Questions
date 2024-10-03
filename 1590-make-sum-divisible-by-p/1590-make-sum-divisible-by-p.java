class Solution {
    public int minSubarray(int[] nums, int p) {
        int target = 0; // target remainder
        for(int num : nums) target = (target + num) % p;
        if(target == 0) return 0;
        
        var map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        
        int n = nums.length;
        int cur = 0;
        int ans = n;
        
        for(int i=0; i<n; ++i){
            cur = (cur + nums[i])%p;
            int key = (cur-target+p)%p;
            
            if(map.containsKey(key))
                ans = Math.min(ans, i-map.get(key));
            map.put(cur, i);
        }
        
        return ans >= n ? -1 : ans;
    }
}




// memory limit exceeded

// class Solution {
//     public int minSubarray(int[] nums, int p) {
//         int[] mod = new int[p];
//         Arrays.fill(mod, -100);
//         mod[0] = -1;
//         int n = nums.length;
//         long cur = 0;
//         int target = 0;
//         for(int num: nums) target = (target + num) % p;
//         if(target==0) return 0;
//         int ans = n;
        
        
//         for(int i=0; i<n; ++i){
//             cur += nums[i];
//             int cur = (int)(cur%p);
//             if(mod[(cur-target+p)%p] != -100)
//                 ans = Math.min(ans, i-mod[(cur-target+p)%p]);
//             mod[cur] = i;
//         }
        
//         return ans >= n ? -1 : ans;
//     }
// }