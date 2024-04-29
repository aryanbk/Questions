class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int mx = 0;
        for(int i=0; i<n; ++i) mx = Math.max(mx, nums[i]);
        mx = Math.max(mx, k);
        
        for(; mx!=0; mx/=2, k/=2){
            int xor = k%2==0 ? 0 : 1;
            for(int j=0; j<n; ++j){
                xor ^= nums[j]%2==0 ? 0 : 1;
                nums[j] /= 2;
            }            
            ans += xor;
        }
        
        return ans;
    }
}