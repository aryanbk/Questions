class Solution:
    def numRollsToTarget(self, n: int, k: int, target: int) -> int:
        def solve(n, target):
            nonlocal k
            if target==0 and n==0: return 1
            if target<=0 or n<=0 : return 0
            if dp[target][n]!=-1: return dp[target][n]
            
            ans, lim = 0, min(k, target)+1
            for i in range(1, lim):
                ans+=solve(n-1, target-i)
            dp[target][n]=ans
            return dp[target][n]
        
        dp=[[-1]*(n+1) for i in range(target+1)]
        return solve(n, target)%(10**9+7)