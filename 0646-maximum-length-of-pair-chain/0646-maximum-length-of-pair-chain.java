class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a,b)-> a[1]-b[1]);
        
        int ans = 1;
        int last = pairs[0][1];
        
        for(int i=1; i<pairs.length; ++i){
            if(pairs[i][0] > last){
                last = pairs[i][1];
                ++ans;
            }
        }
        return ans;
    }
}

/////////////////////////////////////////////////////////////////


// // russian doll envelop problem : changes marked
// //
// class Solution {
//     public int findLongestChain(int[][] pairs) {
//         Arrays.sort(pairs, (a, b) -> { // change
//             return a[0] - b[0];
//         });
//         return lengthOfLIS(pairs);
//     }

//     public int lengthOfLIS(int[][] nums) { // LIS with binary search wont work
//         int n = nums.length;
//         int[] dp = new int[n];
//         Arrays.fill(dp, 1);
//         int ans = 1;

//         for (int i = 0; i < n; ++i) {
//             for (int j = 0; j < i; ++j) {
//                 if (nums[i][0] > nums[j][1]) dp[i] = Math.max(dp[i], dp[j] + 1);
//             }
//             ans = Math.max(ans, dp[i]);
//         }

//         return ans;
//     }
// }

/////////////////////////////////////////////////////////////////

// // wrong attempts
//
// class Solution {
//     public int findLongestChain(int[][] pairs) {
//         Arrays.sort(pairs, (a, b) -> {
//             if(a[1] == b[0])
//                 return a[1] - b[1]; // bit change
//             return a[1] - b[0];
//         });
//         // for(var p: pairs)
//         //     System.out.println(Arrays.toString(p));
//         return lengthOfLIS(pairs);
//     }

//     public int lengthOfLIS(int[][] nums) {
//         int len = 0;
//         for (var n: nums) {
//             if (len == 0 || nums[len - 1][1] < n[0]) //change
//                 nums[len++] = n;
//             else
//                 nums[bsLowerBound(0, len - 1, n[0], nums)] = n;
//         }
//         // for(var p: nums)
//         //     System.out.println(Arrays.toString(p));
//         return len;
//     }

//     private int bsLowerBound(int left, int right, int x, int[][] nums) {
//         while (left <= right) {
//             int mid = left + (right - left) / 2;
//             if (nums[mid][1] > x) { //change
//                 right = mid - 1;
//             } else {
//                 left = mid + 1;
//             }
//         }
//         return left;
//     }
    
// }