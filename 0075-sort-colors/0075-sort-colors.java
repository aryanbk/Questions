class Solution {
    public void sortColors(int[] nums) {
        int i=0; // pointer for 0
        int j=0; // pointer for 1
        int k = nums.length - 1; // pointer for 2
        
        while(j<=k){
            if(nums[j] == 0){
                swap(j, i, nums);
                ++i;
                ++j;
            }
            else if(nums[j] == 2){
                swap(j, k, nums);
                --k;
            }
            else if(nums[i] == 1)
                ++j;
        }
    }
    
    void swap(int a, int b, int[] nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}


// class Solution {
//     public void sortColors(int[] nums) {
//         int n = nums.length;
//         int i=0;
//         int j=n-1;
//         for(int x=0; x<=j; ++x){
//             if(nums[x] < 1)
//                 swap(nums, x, i++);
//             else if(nums[x] > 1)
//                 swap(nums, x--, j--);
//         }
//     }
    
//     void swap(int[] nums, int i, int j){
//         int temp = nums[i];
//         nums[i] = nums[j];
//         nums[j] = temp;
//     }
// }



// // O(n)
//
// class Solution {
//     public void sortColors(int[] nums) {
//         int n = nums.length;
//         int i=0;
//         int j=n-1;
//         for(int x=0; x<=j; ++x){
//             if(nums[x] < 1){
//                 swap(nums, x, i);
//                 i++;
//             }
//             else if(nums[x] > 1){
//                 swap(nums, x, j);
//                 j--;
//                 x--;
//             }
//         }
//     }
    
//     void swap(int[] nums, int i, int j){
//         int temp = nums[i];
//         nums[i] = nums[j];
//         nums[j] = temp;
//     }
// }

// // O(n log n)
//
// class Solution {
//     public void sortColors(int[] nums) {
//         Arrays.sort(nums);
//     }
// }