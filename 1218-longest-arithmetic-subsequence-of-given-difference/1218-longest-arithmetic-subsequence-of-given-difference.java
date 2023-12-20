class Solution {
    public int longestSubsequence(int[] arr, int diff) {
        int n = arr.length;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<n; ++i){
            if(map.containsKey(arr[i]-diff)){
                int one = map.get(arr[i]-diff)+1;
                int two = map.getOrDefault(arr[i], 0);
                map.put(arr[i], Math.max(one, two));
            }
            else
                map.put(arr[i], 0);
            ans = Math.max(ans, map.getOrDefault(arr[i], 0));
        }
        return ans + 1;
    }
}


// // TLE
//
// class Solution {
//     public int longestSubsequence(int[] arr, int diff) {
//         int n = arr.length;
//         int ans = 0;
//         int[] dp = new int[n];
        
//         for(int i=0; i<n; ++i){
//             for(int j=0; j<i; ++j){
//                 if(arr[i] - arr[j] == diff)
//                     dp[i] = Math.max(dp[i], dp[j]+1);
//                 ans = Math.max(ans, dp[i]);
//             }
//         }
//         return ans + 1;
//     }
// }