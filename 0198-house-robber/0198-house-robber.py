class Solution:
    def rob(self, nums: List[int]) -> int:
        def knap(idx):
            if idx>=len(nums):
                return 0
            if memo[idx]==-1:
                memo[idx] = max(knap(idx+2)+nums[idx], knap(idx+1))
            return memo[idx]
        
        
        memo=[-1]*(len(nums)+1)
        return knap(0)
        
        
# class Solution:
#     def rob(self, nums: List[int]) -> int:
#         def rec(idx, sumt):
#             if idx>=len(nums):
#                 return sumt
#             return max( rec(idx+2, sumt+nums[idx]), rec(idx+1, sumt) )
        
#         return rec(0, 0)
        
        