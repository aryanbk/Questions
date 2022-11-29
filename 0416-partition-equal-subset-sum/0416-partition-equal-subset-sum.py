class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        def subsetsum(trgt):
            ln=len(nums)
            dp = [[False]*(trgt+1) for _ in range(ln+1)]
            for l in range(ln+1):
                for t in range(trgt+1):
                    if t==0:
                        dp[l][t]=True
                    elif l==0:
                        dp[l][t]=False
                    elif t>=nums[l-1]:
                        dp[l][t] = dp[l-1][t] or dp[l-1][t-nums[l-1]]
                    else:
                        dp[l][t] = dp[l-1][t]
            return dp[ln][trgt]
        
        sumt=sum(nums)
        return False if sumt%2 else subsetsum(sumt//2)
                  

# class Solution:
#     def canPartition(self, nums: List[int]) -> bool:
#         target = sum(nums)
#         if target%2==1:
#             return False
#         target = target//2
        
#         def helper(ptr, target):
#             if target==0:
#                 return True
#             if ptr>=len(nums) or target<0:
#                 return False
#             if memo[ptr][target]==-1:
#                 memo[ptr][target] = int(helper(ptr+1, target) or helper(ptr+1, target-nums[ptr]))
#             return memo[ptr][target]==1
            
#         memo = [[-1]*(target+1) for _ in range(len(nums))]
#         return helper(0, target)
        