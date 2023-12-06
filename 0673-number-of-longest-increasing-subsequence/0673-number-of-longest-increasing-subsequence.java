// //
// // ises another for loop to count numberOfLIS
// // 
// class Solution {
//     public int findNumberOfLIS(int[] nums) {
//         return lengthOfLIS(nums);
//     }

//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;
//         int[] dp = new int[n];
//         int[] count = new int[n];
//         for(int i=0; i<n; ++i) dp[i] = count[i] = 1;
        
//         int ans = 1; // length of LIS
//         int numberOfLIS = 0;

//         for (int i = 0; i < n; ++i) {
//             for (int j = 0; j < i; ++j) {
//                 if (nums[i] > nums[j]) {
//                     if (dp[i] < dp[j] + 1) {
//                         dp[i] = dp[j] + 1;
//                         count[i] = count[j];
//                     } else if (dp[i] == dp[j] + 1) {
//                         count[i] += count[j];
//                     }
//                 }
//             }
//             ans = Math.max(ans, dp[i]);
//         }

//         for (int i = 0; i < n; ++i) {
//             if (dp[i] == ans) {
//                 numberOfLIS += count[i];
//             }
//         }

//         return numberOfLIS;
//     }
// }



//
// count numberOfLIS inside the main for loop itself
// 
class Solution {
    public int findNumberOfLIS(int[] nums) {
        return lengthOfLIS(nums);
    }
    
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int mxLen = 1; // ans for LIS
        int numberOfLIS = 0;
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[i] == dp[j] + 1) {
                        count[i] += count[j];
                    }
                }
            }
            
            // Update mxLen and numberOfLIS after inner loop
            if (dp[i] > mxLen) {
                mxLen = dp[i];
                numberOfLIS = count[i];
            } else if (dp[i] == mxLen) {
                numberOfLIS += count[i];
            }
        }
        
        return numberOfLIS;
    }
}