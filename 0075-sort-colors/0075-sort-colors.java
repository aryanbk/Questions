class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int i=0;
        int j=n-1;
        for(int x=0; x<=j; ++x){
            if(nums[x] < 1){
                swap(nums, x, i);
                i++;
            }
            else if(nums[x] > 1){
                swap(nums, x, j);
                j--;
                x--;
            }
        }
    }
    
    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


// class Solution {
//     public void sortColors(int[] nums) {
//         Arrays.sort(nums);
//     }
// }