class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int n = items.length;
        Arrays.sort(items, (a, b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        int[] mxBeauty = new int[n];
        mxBeauty[0] = items[0][1];
        for(int i=1; i<n; ++i)
            mxBeauty[i] = Math.max(mxBeauty[i-1], items[i][1]);
        int[] ans = new int[queries.length];
        for(int i=0; i<queries.length; ++i){
            int idx = bs(items, queries[i]);
            ans[i] = idx==-1 ? 0 : mxBeauty[idx];
        }
        
        return ans;
    }
    
    int bs(int[][] nums, int x){
        int lo = 0;
        int hi = nums.length-1;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(nums[mid][0] <= x) lo = mid + 1;
            else hi = mid - 1;
        }
        return hi;
    }
}