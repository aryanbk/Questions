class Solution {
    public int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0;
        
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);
        
        slow = 0;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
    }
}


// class Solution {
//     public int findDuplicate(int[] nums) {
//         boolean[] ans = new boolean[nums.length];
//         for(int i=0;i<nums.length;i++){
//             if(ans[nums[i]]){
//                 return nums[i];
//             }
//             ans[nums[i]]=true;
//         }
//         return -1;
//     }
// }


// // wont work
// // All the integers in nums appear only once except for precisely one integer which appears two or more times.
//
// class Solution {
//     public int findDuplicate(int[] nums) {
//         int sumt = 0;
//         for(int n: nums) sumt += n;
//         return sumt - (nums.length*(nums.length-1)/2);
//     }
// }