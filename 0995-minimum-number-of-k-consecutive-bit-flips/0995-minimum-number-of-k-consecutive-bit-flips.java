class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int start = -1;
        int end = -1;
        int n = nums.length;
        int flip = 0;
        
        for(int i=0; i<n; ++i){
            // System.out.println(i+" "+start+" "+end+" "+flip);
            if((start<=i && i<=end && nums[i]==1)){
                ++flip;
                start = end+1;
                end = i+k-1;
                if(end >= n) return -1;
            }
            else if((start<i && end<i) && nums[i]==0){
                ++flip;
                start=i+1;
                end = i+k-1;
                if(end >= n) return -1;
            }
            else if((start>i && end>i) && nums[i]==0){
                for(int a=start; a<=end; ++a) nums[a] ^= 1;
                ++flip;
                start=i+1;
                end = i+k-1;
                if(end >= n) return -1;
            }
            // System.out.println(i+" "+start+" "+end+" "+flip);
        }
        
        // return end >=n  && start>=n? -1 : flip;
        return flip;
    }
}