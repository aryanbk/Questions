class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int sumt = 0;
        for(int a: nums)
            sumt += a;
        int currSum = 0;
        int[] ans = new int[n];
        for(int i=0; i<n; ++i){
            currSum += nums[i];
            
            // int next = sumt - curr - nums[i];
            // int nextMin = (n-1-i)*nums[i];
            // int currPlus = i*nums[i];
            // ans[i] = next - nextMin + currPlus - curr;
            // ans[i] = sumt - (n-2)*nums[i]
            
            ans[i] = sumt - currSum - (n-i-1)*nums[i] + i*nums[i] - currSum + nums[i];
            
            
            // ans[i] = sumt - ((n-i)*nums[i]) + (i*nums[i]) - curr;
            // System.out.println(sumt+" "+((n-i)*nums[i])+" "+(i*nums[i])+" "+curr);
            // 10 - 2*3 + 1*3 - 2
        }
        return ans;
    }
}