class Solution {
    public int specialArray(int[] nums) {
        for(int i=0; i<=1000; ++i){
            int count = 0;
            for(int j=0; j<nums.length; ++j)
                count += nums[j]>=i ? 1 : 0;
            if(count == i)
                return i;
            if(count == 0)
                return -1;
        }
        return -1;
    }
}