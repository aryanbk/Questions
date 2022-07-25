class Solution {
    public int[] searchRange(int[] nums, int target) {
        int st=0, end=nums.length-1;
        while(st<=end){
            int mid=st+(end-st)/2;
            if(nums[mid]==target){
                int i=mid,j=mid;
                while(i>=0 && target==nums[i])i--;
                while(j<nums.length && target==nums[j]) j++;
                return new int[]{i+1, j-1};
            }else if(nums[mid]<target) st=mid+1;
            else end=mid-1;
        }
        return new int[]{-1, -1};
    }
}