class Solution {
    public int minOperations(int[] nums) {
        var map = new HashMap<Integer, Integer>();
        for(int n: nums)
            map.put(n, map.getOrDefault(n, 0) + 1);
        
        int ans = 0;
        for(int key : map.keySet()){
            if(map.get(key) == 1) return -1;
            ans += (map.get(key) + 2)/3;
        }
        
        return ans;
    }
}

// https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/




// class Solution {
//     public int minOperations(int[] nums) {
//         var map = new HashMap<Integer, Integer>();
//         for(int n: nums)
//             map.put(n, map.getOrDefault(n, 0) + 1);
        
//         int ans = 0;
//         for(int key : map.keySet()){
//             if(map.het(key) == 1) return -1;
//             if(map.get(key)%3 == 0) ans += map.get(key)/3;
//             else ans += map.get(key)/3 + 1;
//         }
        
//         return ans;
//     }
// }