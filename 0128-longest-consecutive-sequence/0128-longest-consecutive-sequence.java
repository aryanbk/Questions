class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        int ans = 0;
        Map<Integer, Integer> count = new HashMap<>();
        
        for(int i=0; i<n; ++i){
            int a = nums[i];
            if(count.containsKey(a)) continue;
            int right = count.getOrDefault(a+1, 0);
            int left = count.getOrDefault(a-1, 0);
            int cur = left+right+1;
            
            ans = Math.max(ans, cur);
            count.put(a, cur);
            count.put(a-left, cur);
            count.put(a+right, cur);
        } 

        return ans;
    }
}



// class Solution {
//     public int longestConsecutive(int[] nums) {
//         Set<Integer> set = new HashSet<>();
//         for(int n: nums) set.add(n);
//         int ans=0;
//         for(int n: nums){
//             if(!set.contains(n-1)){
//                 int cnt = 1, temp=n+1;
//                 while(set.contains(temp)){
//                     cnt++;
//                     temp++;
//                 }
//                 ans = Math.max(ans, cnt);
//             }
//         }
//         return ans;
//     }
// }