// // Quick Select TLE
// // avg TC O(n)
// // worst TC O(n^2)
// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         k = nums.length - k;
//         return quickSelect(nums, 0, nums.length-1, k);
//     }
    
//     int quickSelect(int[] nums, int a, int b, int k){
//         int ptr = a;
//         for(int i=a; i<b; ++i){
//             if(nums[i] <= nums[b]) swap(nums, i, ptr++);
//         }
//         swap(nums, ptr, b);
//         if(ptr>k) return quickSelect(nums, a, ptr-1, k);
//         if(ptr<k) return quickSelect(nums, ptr+1, b, k);
//         return nums[ptr];
//     }
    
//     void swap(int[] nums, int a, int b){
//         int temp = nums[b];
//         nums[b] = nums[a];
//         nums[a] = temp;
//     }
// }


class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> hp = new PriorityQueue<>();
        for(int i: nums){
            hp.add(i);
            if(hp.size()>k) hp.poll();
        }
        return hp.peek();
    }
}