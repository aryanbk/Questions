class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums)==1:
            return nums[0]
        t=[0]*(len(nums))
        t[-1], t[-2] = nums[-1], max(nums[-1], nums[-2])
        
        for i in range(len(nums)-3, -1, -1):
            t[i]=max(nums[i]+t[i+2], t[i+1])
        
        return t[0]
        
        
    
    
################################
# class Solution:
#     def rob(self, nums: List[int]) -> int:
#         def knap(idx):
#             if idx>=len(nums):
#                 return 0
#             if memo[idx]==-1:
#                 memo[idx] = max(knap(idx+2)+nums[idx], knap(idx+1))
#             return memo[idx]
        
#         memo=[-1]*(len(nums)+1)
#         return knap(0)
        
############################
# class Solution:
#     def rob(self, nums: List[int]) -> int:
#         def rec(idx, sumt):
#             if idx>=len(nums):
#                 return sumt
#             return max( rec(idx+2, sumt+nums[idx]), rec(idx+1, sumt) )
        
#         return rec(0, 0)
        
        
        