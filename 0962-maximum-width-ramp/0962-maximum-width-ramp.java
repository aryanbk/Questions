class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int[][] pairs = new int[n][2];
        for(int i=0; i<n; ++i) pairs[i] = new int[]{nums[i], i};
        Arrays.sort(pairs, (a,b) -> a[0]-b[0]);
        
        int mn = Integer.MAX_VALUE;
        int ans = 0;
        
        for(int i=0; i<n; ++i){
            mn = Math.min(mn, pairs[i][1]);
            ans = Math.max(ans, pairs[i][1]-mn);
        }
        return ans;
    }
}