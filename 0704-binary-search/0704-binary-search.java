class Solution {
    public int search(int[] nums, int target) {
        int ans = Arrays.binarySearch(nums, target);
        return ans < 0 ? -1 : ans;
    }
}


// class Solution {
//     public int search(int[] nums, int target) {
//         if (nums == null || nums.length == 0) return -1;
//         int left = 0;
//         int right = nums.length - 1;
//         while (left <= right) {
//             int mid = left + (right - left) / 2;
//             if (nums[mid] == target) return mid;
//             if (nums[mid] > target) right = mid - 1;
//             else left = mid + 1;
//         }
//         return -1;
//     }
// }