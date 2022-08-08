class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length, res=1;
        int[] dp=new int[n];
        dp[n-1]=1;
        for(int i=n-2; i>=0; i--){
            int ans=1;
            for(int j=i+1; j<n; j++)
                if(nums[i]<nums[j]) ans=Math.max(ans, 1+dp[j]);
            dp[i]=ans;
            res=Math.max(res, ans);
        }
        return res;
    }
}