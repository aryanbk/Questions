class Solution {
    int ans = 0;
    public int subsetXORSum(int[] nums) {
        bk(0, nums, 0);
        return ans;
    }
    void bk(int i, int[] nums, int cur){
        if(i==nums.length)
            ans += cur;
        else{
            bk(i+1, nums, cur);
            bk(i+1, nums, cur^nums[i]);
        }
    }
}






// class Solution {
//     int ans = 0;
//     public int subsetXORSum(int[] nums) {
//         // return bk(0, nums) + nums[0];
//         bk(0, nums, 0);
//         return ans;
//     }
//     int bk(int i, int[] nums, int cur){
//         if(i==nums.length){
//             ans += cur;
//             return cur;
//         }
//         bk(i+1, nums, cur);
//         bk(i+1, nums, cur^nums[i]);
//         return cur;
//     }
// }