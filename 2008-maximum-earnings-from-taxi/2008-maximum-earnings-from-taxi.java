class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        for(int[] r: rides){
            r[2] += r[1] - r[0];
        }
        return jobScheduling(rides);
    }

    public long jobScheduling(int[][] time) {
        // int n = start.length;
        // int[][] time = new int[n][3]; // accumulate all 3
        // for(int i=0; i<n; ++i){
        //     time[i][0] = start[i];
        //     time[i][1] = end[i];
        //     time[i][2] = profit[i];
        // }
        
        int n = time.length;
        Arrays.sort(time, (a, b)->{
            return a[1]==b[1] ? b[0]-a[0] : a[1]-b[1];
        }); // sort based on end time
        
        int[] end = new int[n];
        long[] profit = new long[n];
        
        for(int i=0; i<n; ++i){
            end[i] = time[i][1];
            profit[i] = time[i][2];
        } // made copy of end and profite for BS and ST
        
        long ans = 0;
        SegmentTree seg = new SegmentTree(profit);
        
        for(int i=1; i<n; ++i){
            int idx = bs(end, 0, i-1, time[i][0]);
            long mx = seg.query(0, idx);
            profit[i] += mx;
            seg.update(i, profit[i]);
            ans = Math.max(ans, profit[i]);
        }
        return Math.max(ans, profit[0]);
    }
    
    int bs(int[] nums, int i, int j, int x){
        int ans = -1;
        while(i<=j){
            int mid = i + (j-i)/2;
            if(nums[mid] <= x){
                ans = mid;
                i = mid + 1;
            }
            else 
                j = mid - 1;
        }
        return ans;
    }
}


class SegmentTree {
    long[] tree;
    int n;

    public SegmentTree(long[] nums) {
        n = nums.length;
        int height = (int) (Math.ceil(Math.log(n) / Math.log(2)));
        int mxSize = 2 * (int) Math.pow(2, height) - 1;
        tree = new long[mxSize];
        buildTree(nums, 0, 0, n - 1);
    }
    // or we can use 4*n as size
    // tree = new int[4 * n];

    private void buildTree(long[] nums, int index, int start, int end) {
        if (start == end) {
            tree[index] = nums[start];
            return;
        }

        int mid = start + (end - start) / 2;
        buildTree(nums, 2 * index + 1, start, mid);
        buildTree(nums, 2 * index + 2, mid + 1, end);
        tree[index] = Math.max(tree[2 * index + 1], tree[2 * index + 2]);
    }

    public long query(int left, int right) {
        if(right < left) return 0;
        return queryHelper(0, 0, n - 1, left, right);
    }

    private long queryHelper(int index, int start, int end, int left, int right) {
        if (start > right || end < left) {
            return Integer.MIN_VALUE; // Out of range
        }

        if (start >= left && end <= right) {
            return tree[index]; // Current segment is completely within the range
        }

        int mid = start + (end - start) / 2;
        long leftMax = queryHelper(2 * index + 1, start, mid, left, right);
        long rightMax = queryHelper(2 * index + 2, mid + 1, end, left, right);

        return Math.max(leftMax, rightMax);
    }

    public void update(int index, long val) {
        updateHelper(0, 0, n - 1, index, val);
    }

    private void updateHelper(int index, int start, int end, int idx, long val) {
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
