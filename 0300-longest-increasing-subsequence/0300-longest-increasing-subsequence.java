// binary search O(n logn)
// 
// 
class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = 0;
        for(int n: nums){
            if(len==0 || nums[len-1] < n)
                nums[len++] = n;
            else
                nums[bsLowerBound(0, len-1, n, nums)] = n;
        }
        return len;
    }
    
    private int bsLowerBound(int left, int right, int x, int[] nums) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}


// //printing LIS
// //
// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;
//         int[] dp = new int[n];
//         Arrays.fill(dp, 1);
//         int[] map = new int[n];
        
//         for(int i = 0; i < n; ++i) {
//             for(int j = 0; j < i; ++j) {
//                 if(nums[i] > nums[j]) {
//                     if(dp[j] + 1 > dp[i]) {
//                         dp[i] = dp[j] + 1;
//                         map[i] = j;
//                     }
//                 }
//             }
//         }
        
//         int maxLen = 0;
//         int endIdx = 0;
//         for(int i = 0; i < n; ++i) {
//             if(dp[i] > maxLen) {
//                 maxLen = dp[i];
//                 endIdx = i;
//             }
//         }
        
//         List<Integer> listLIS = new ArrayList<>();
//         while(maxLen > 0) {
//             listLIS.add(nums[endIdx]);
//             endIdx = map[endIdx];
//             maxLen--;
//         }
        
//         Collections.reverse(listLIS);
//         System.out.println(listLIS);
        
//         return listLIS.size(); // Return the length of LIS
//     }
// }


// // dp[i] = length of LIS ending at index i of nums;
// //
// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;
//         int[]dp = new int[n];
//         Arrays.fill(dp, 1);
//         int ans = 1;
        
//         for(int i=0; i<n; ++i){
//             for(int j=0; j<i; ++j){
//                 if(nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j]+1);
//             }
//             ans = Math.max(ans, dp[i]);
//         }
        
//         return ans;
//     }
// }


// // tabulation (instead of starting j at 0, start j from i)
// // 1D array
// // 
// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;
//         int[]dp = new int[n+1];
        
//         for(int i=1; i<n+1; ++i){
//             int[] newDp = new int[n+1];
//             for(int j=i; j<n+1; ++j){
//                 newDp[j] = dp[j];
//                 if(j==n || nums[i-1] < nums[j])
//                     newDp[j] = Math.max(newDp[j], 1+dp[i-1]);
//             }
//             dp = newDp;
//         }
        
//         return dp[n];
//     }
// }


// // tabulation 
// // 1D array
// // 
// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;
//         int[]dp = new int[n+1];
        
//         for(int i=1; i<n+1; ++i){
//             int[] newDp = new int[n+1];
//             for(int j=0; j<n+1; ++j){
//                 newDp[j] = dp[j];
//                 if(j==n || nums[i-1] < nums[j])
//                     newDp[j] = Math.max(newDp[j], 1+dp[i-1]);
//             }
//             dp = newDp;
//         }
        
//         return dp[n];
//     }
// }



// // tabulation
// // 2D array
// //
// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;
//         int[][] dp = new int[n+1][n+1];
        
//         for(int i=1; i<n+1; ++i){
//             for(int j=0; j<n+1; ++j){
//                 dp[i][j] = dp[i-1][j];
//                 if(j==n || nums[i-1] < nums[j])
//                     dp[i][j] = Math.max(dp[i][j], 1+dp[i-1][i-1]);
//             }
//         }
        
//         return dp[n][n];
//     }
// }
// // i == length of array
// // j == index of element from which last element of subseq should be lesser
// // if j==n take it as +inf and consider all current element are smaller than this



// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         return find(nums.length, 100000, nums);
//     }
//     private int find(int l, int last, int[] nums){
//         if(l==0) return 0;
//         int ans = find(l-1, last, nums);
//         if(nums[l-1] < last)
//             ans = Math.max(ans, 1 + find(l-1, nums[l-1], nums));
//         return ans;
//     }
// }