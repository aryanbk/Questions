class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int l = 0;
        int r = n-1;
        for(int i=n-1; i>=0; --i){
            if(Math.abs(nums[l]) > Math.abs(nums[r])){
                ans[i] = nums[l]*nums[l];
                ++l;
            }else{
                ans[i] = nums[r]*nums[r];
                --r;
            }
        }
        return ans;
    }
}


// class Solution {
//     public int[] sortedSquares(int[] nums) {
//         for(int i=0; i<nums.length; ++i) nums[i] *= nums[i];
//         Arrays.sort(nums);
//         return nums;
//     }
// }