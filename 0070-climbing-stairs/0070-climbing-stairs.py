class Solution:
    def climbStairs(self, n: int) -> int:
        
        def climb(step):
            if step<0:
                return 0
            if memo[step]==-1:
                memo[step] = climb(step-1) + climb(step-2)
            return memo[step]
        
        memo = [-1]*(n+1)
        memo[0] = 1
        
        return climb(n)
        