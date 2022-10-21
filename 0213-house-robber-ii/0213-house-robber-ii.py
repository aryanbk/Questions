class Solution:
    def rob(self, nums: List[int]) -> int:
        def dp(i, j):
            prev1 = prev2 = 0
            for x in range(i, j+1):
                prev1, prev2 = max(prev2+nums[x], prev1), prev1
            return prev1
        
        
        return max(nums[0] + dp(2, len(nums)-2), dp(1, len(nums)-1))