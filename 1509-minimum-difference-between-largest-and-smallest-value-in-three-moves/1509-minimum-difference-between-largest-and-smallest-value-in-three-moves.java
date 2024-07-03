class Solution {
    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        return solve(0, 0, nums.length-1, nums);
    }
    
    // only 3 moves so dp is not required
    // x is dependant on i & j, x is not a state, i used it for convenience
    // i & j are only state
    
    int solve(int x, int i, int j, int[] nums){
        if(x==3) return j>i ? nums[j]-nums[i] : 0;
        return Math.min(solve(x+1, i+1, j, nums), solve(x+1, i, j-1, nums));
    }
}