class Solution {
    public int[] getMaximumXor(int[] nums, int mxBit) {
        int n = nums.length;
        int[] xor = new int[n]; // to store reverse xor of the nums elements
        xor[n-1] = nums[0];
        for(int i=n-2; i>=0; --i) xor[i] = xor[i+1] ^ nums[n-i-1];
        
        int[] ans = new int[n];
        for(int i=0; i<n; ++i){
            int cur = xor[i];
            int res = 0;
            for(int x=0; x<mxBit; ++x, cur /= 2){
                if(cur%2 == 0) res = res | (1 << x); 
            } // if cur has unset bit then set bit in res
            ans[i] = res;
        }
        
        return ans;
    }
}