class Solution {
    public int lengthOfLIS(int[] nums, int k) {
        int n = nums.length;
        int mx = 0;
        for(int x: nums) mx = Math.max(x, mx);
        
        int ans = 0;
        int[] dp = new int[mx+1];
        SegmentTree seg = new SegmentTree(dp);
        
        for(int x: nums){
            int res = seg.query(Math.max(x-k, 0), x-1);
            if(dp[x] < res + 1){
                dp[x] = res + 1;
                seg.update(x, res + 1);
            }
            ans = Math.max(ans, dp[x]);
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


// // TLE
//
// class Solution {
//     public int lengthOfLIS(int[] nums, int k) {
//         int n=nums.length, res=1;
//         int[] dp=new int[n];
//         dp[n-1]=1;
//         for(int i=n-2; i>=0; i--){
//             int ans=1;
//             for(int j=i+1; j<n; j++)
//                 if(nums[i]<nums[j] && nums[j]<=nums[i]+k) ans=Math.max(ans, 1+dp[j]);
//             dp[i]=ans;
//             res=Math.max(res, ans);
//         }
//         return res;
//     }
// }


// // first attempt - wont work - it's wrong approch
//
// class Solution {
//     public int lengthOfLIS(int[] nums, int k) {
//         int length = 0; // answer
        
//         for(int n: nums){
//             if(length==0 || (nums[length-1] < n && n - nums[length-1] <= k))
//                 nums[length++] = n;
//             else{
//                 // int insertionPoint = Arrays.binarySearch(nums, 0, length, n-k);
//                 int insertionPoint = bs(nums, 0, length-1, n, k);
//                 if(insertionPoint < 0)
//                     insertionPoint = (insertionPoint + 1) * -1;
//                 nums[insertionPoint] = n;
//                 System.out.println(insertionPoint);
//             }
//             System.out.println(Arrays.toString(nums)+" "+length);
//         }
        
//         return length;
//     }
    
//     int bs(int[] nums, int i, int j, int x, int k){
//         int ans = 0;
//         while(i<=j){
//             int mid = i + (j-i)/2;
//             if(nums[mid]<x && x-nums[mid] <= k){
//                 ans = mid+1;
//                 i = mid + 1;
//             }
//             else if(nums[mid] > x){
//                 j = mid - 1;
//             }
//             else{
//                 i = mid + 1;
//             }
//         }
//         return ans;
//     }
    
// }