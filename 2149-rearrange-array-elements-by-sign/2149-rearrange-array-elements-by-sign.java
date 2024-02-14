class Solution {
    public int[] rearrangeArray(int[] nums) {
        int pos = 0;
        int neg = 0;
        int n = nums.length; 
        int[] ans = new int[n];
        
        for(int i=0; i<n; i+=2){
            while(pos<n && nums[pos] < 0) ++pos;
            while(neg<n && nums[neg] > 0) ++neg;
            ans[i] = nums[pos++];
            ans[i+1] = nums[neg++];
        }
        
        return ans;
    }
    
}