class Solution {
    public int[] sortArray(int[] nums) {
        return sort(0, nums.length-1, nums);
    }
    
    int[] sort(int i, int j, int[] nums){
        if(i==j) return new int[]{nums[i]};
        int mid = i + (j-i)/2;
        int[] left = sort(i, mid, nums);
        int[] right = sort(mid+1, j, nums);
        
        return merge(left, right, nums);
    }
    
    int[] merge(int[] left, int[] right, int[] nums){
        int l = left.length;
        int r = right.length;
        int[] ans = new int[l+r];
        int i = 0;
        int j = 0;
        int ptr = 0;
        
        
        while(i<l && j<r){
            if(left[i] > right[j])
                ans[ptr] = right[j++];
            else
                ans[ptr] = left[i++];
            ++ptr;
        }
        while(i<l){
            ans[ptr] = left[i++];
            ++ptr;
        }
        while(j<r){
            ans[ptr] = right[j++];
            ++ptr;
        }
        
        return ans;
    }
}