class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] bit = new int[32]; // to keep track of index of element who has set bit
        Arrays.fill(bit, -1);
        int[] ans = new int[n];
        
        for(int i=n-1; i>=0; --i){
            int curLen = 0;
            
            for(int j=0; j<32; nums[i]/=2, ++j){
                if(nums[i]%2 == 0 && bit[j] != -1)
                    curLen = Math.max(curLen, bit[j] - i);
                else if(nums[i]%2 == 1)
                    bit[j] = i;
            }
            
            ans[i] = curLen + 1;
        }
        
        return ans;
    }
}