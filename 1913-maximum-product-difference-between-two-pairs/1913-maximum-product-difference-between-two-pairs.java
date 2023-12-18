class Solution {
    public int maxProductDifference(int[] nums) {
        int n = nums.length;
        int mx1 = 0;
        int mx2 = 0;
        int mn1 = 1000000;
        int mn2 = 1000000;
        
        for(int x: nums){
            if(x>mx1){
                mx2 = mx1;
                mx1 = x;
            }else{
                mx2 = Math.max(mx2, x);
            }
            
            if(x<mn1){
                mn2 = mn1;
                mn1 = x;
            }else{
                mn2 = Math.min(mn2, x);
            }
        }
        
        return mx1*mx2 - mn1*mn2;
    }
}


// class Solution {
//     public int maxProductDifference(int[] nums) {
//         int n = nums.length;
//         Arrays.sort(nums);
//         return (nums[n-1]*nums[n-2]) - (nums[1]*nums[0]);
//     }
// }