class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] bit = new int[32];
        Arrays.fill(bit, -1);
        int[] ans = new int[n];
        
        for(int i=n-1; i>=0; --i){
            int curLen = 0;
            for(int j=0; j<32; nums[i]/=2, ++j){
                // System.out.println(i+" "+nums[i]+" "+bit[j]+" "+j);
                if(nums[i]%2==0 && bit[j]!=-1)
                    curLen = Math.max(curLen, bit[j] - i);
                else if(nums[i]%2==1){
                    bit[j] = i;
                }
                // System.out.println(Arrays.toString(bit));
            }
            ans[i] = curLen+1;
        }
        return ans;
    }
}