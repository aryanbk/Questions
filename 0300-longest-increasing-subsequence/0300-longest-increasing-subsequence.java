// using segment tree
//
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int mx = -100000;
        int mn = 100000;
        for(int x: nums){
            mx = Math.max(x, mx);
            mn = Math.min(x, mn);
        }
        
        mn *= -1;
        int ans = 0;
        int[] dp = new int[mn + mx + 1];
        SegmentTree seg = new SegmentTree(dp);
        
        for(int x: nums){
            // int res = seg.query(0, Math.max(x+mn-1, 0));
            int res = seg.query(0, x+mn-1);
            if(dp[x+mn] < res + 1){
                dp[x+mn] = res + 1;
                seg.update(x+mn, res + 1);
            }
            ans = Math.max(ans, dp[x+mn]);
        }
        
        return ans;
    }
}

class SegmentTree {
    int[] tree;
    int n;

    public SegmentTree(int[] nums) {
        n = nums.length;
        int height = (int) (Math.ceil(Math.log(n) / Math.log(2)));
        int mxSize = 2 * (int) Math.pow(2, height) - 1;
        tree = new int[mxSize];
        buildTree(nums, 0, 0, n - 1);
    }
    // or we can use 4*n as size
    // tree = new int[4 * n];

    private void buildTree(int[] nums, int index, int start, int end) {
        if (start == end) {
            tree[index] = nums[start];
            return;
        }

        int mid = start + (end - start) / 2;
        buildTree(nums, 2 * index + 1, start, mid);
        buildTree(nums, 2 * index + 2, mid + 1, end);
        tree[index] = Math.max(tree[2 * index + 1], tree[2 * index + 2]);
    }

    public int query(int left, int right) {
        if(right < left) return 0;
        return queryHelper(0, 0, n - 1, left, right);
    }

    private int queryHelper(int index, int start, int end, int left, int right) {
        if (start > right || end < left) {
            return Integer.MIN_VALUE; // Out of range
        }

        if (start >= left && end <= right) {
            return tree[index]; // Current segment is completely within the range
        }

        int mid = start + (end - start) / 2;
        int leftMax = queryHelper(2 * index + 1, start, mid, left, right);
        int rightMax = queryHelper(2 * index + 2, mid + 1, end, left, right);

        return Math.max(leftMax, rightMax);
    }

    public void update(int index, int val) {
        updateHelper(0, 0, n - 1, index, val);
    }

    private void updateHelper(int index, int start, int end, int idx, int val) {
        if (start == end) {
            tree[index] = val;
            return;
        }

        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            updateHelper(2 * index + 1, start, mid, idx, val);
        } else {
            updateHelper(2 * index + 2, mid + 1, end, idx, val);
        }

        tree[index] = Math.max(tree[2 * index + 1], tree[2 * index + 2]);
    }
}



// // binary search built in method
// // 
// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int len = 0;
//         for (int n : nums) {
//             if (len == 0 || nums[len - 1] < n)
//                 nums[len++] = n;
//             else {
//                 int insertionPoint = Arrays.binarySearch(nums, 0, len, n);
//                 if (insertionPoint < 0)
//                     insertionPoint = -(insertionPoint + 1);
//                 nums[insertionPoint] = n;
//             }
//         }
//         return len;
//     }
// }



// // binary search O(n logn)
// // 
// // 
// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int len = 0;
//         for(int n: nums){
//             if(len==0 || nums[len-1] < n)
//                 nums[len++] = n;
//             else
//                 nums[bsLowerBound(0, len-1, n, nums)] = n;
//         }
//         return len;
//     }
    
//     private int bsLowerBound(int left, int right, int x, int[] nums) {
//         while (left <= right) {
//             int mid = left + (right - left) / 2;
//             if (nums[mid] >= x) {
//                 right = mid - 1;
//             } else {
//                 left = mid + 1;
//             }
//         }
//         return left;
//     }
// }


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