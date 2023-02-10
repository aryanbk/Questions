class Solution {
    public int removeDuplicates(int[] nums) {
        int left=0, right = 0, pos = 0, n = nums.length;
        while(right<n){
            while(right<n && nums[left]==nums[right]) right++;
            if(right-left<3){
                while(left<right) nums[pos++] = nums[left++];
            }
            else{
                nums[pos] = nums[left];
                nums[pos+1] = nums[left+1];
                pos += 2;
                left = right;
            }
        }
        return pos;
    }
}