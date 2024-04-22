class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int lo = 0;
        int hi = n-1;
        
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(nums[mid] < nums[(mid-1+n)%n])
                return nums[mid];
            if(nums[mid]>=nums[lo] && nums[mid]<=nums[hi])
                return nums[lo];
            else if(nums[mid] >= nums[lo])
                lo = mid+1;
            else if(nums[mid] < nums[lo])
                hi = mid-1;
        }
        return -1;
    }
}



// class Solution {
//     public int findMin(int[] nums) {
//         int l=nums.length-1;
//         if(nums[0]<=nums[l]) return nums[0];
//         return pivotFind(nums,l);
//     }
//     //
//     int pivotFind(int[] nums, int end){
//         int st=0;
//         while(st<=end){
//             int mid=st+(end-st)/2;
//             System.out.println(st+" "+end+" "+nums[mid]);
//             if(nums[mid]>nums[mid+1]) return nums[mid+1];
//             else if(nums[mid]>=nums[st]) st=mid+1;
//             else if(nums[mid]<nums[st]) end=mid-1;
//         }
//         return nums[st];
//     }
// }