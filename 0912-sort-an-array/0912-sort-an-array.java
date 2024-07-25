class Solution {
    public int[] sortArray(int[] nums) {
        sort(0, nums.length-1, nums);
        return nums;
    }
    
    void sort(int i, int j, int[] nums){
        if(i>=j) return;
        int mid = i + (j-i)/2;
        sort(i, mid, nums);
        sort(mid+1, j, nums);
        merge(i, j, nums);
    }
    
    void merge(int i, int j, int[] nums){
        int mid = i + (j-i)/2;
        int k = mid+1;
        int ptr = 0;
        int[] tmp = new int[j-i+1];
        
        while(i<=mid && k<=j){
            if(nums[i] < nums[k]) tmp[ptr] = nums[i++];
            else tmp[ptr] = nums[k++];
            ++ptr;
        }
        while(i<=mid){
            tmp[ptr] = nums[i++];
            ++ptr;
        }
        while(k<=j){
            tmp[ptr] = nums[k++];
            ++ptr;
        }
        for(ptr=ptr-1; ptr>=0; --ptr, --j) nums[j] = tmp[ptr];
    }
}