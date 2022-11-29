class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        sumt = sum(nums)
        if abs(target)>sumt:
            return 0
        cols, rows = 2*sumt + 1, len(nums)+1
        dp = [[0]*(cols) for _ in range(rows)]
        
        for l in range(rows):
            for t in range(cols):
                if l==0:
                    if t==sumt:
                        dp[l][t] = 1
                    else:
                        dp[l][t] = 0
                if t-nums[l-1]>=0:
                    dp[l][t] += dp[l-1][t-nums[l-1]]
                if t+nums[l-1]<cols:
                    dp[l][t] += dp[l-1][t+nums[l-1]]
        
        return dp[len(nums)][target+sumt]