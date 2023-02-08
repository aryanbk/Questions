class Solution:
    def jump(self, nums: List[int]) -> int:
        n, step, q, vis = len(nums), 1, [0], set([0])
        if n==1: return 0
        while q:
            for _ in range(len(q)):
                curr = q.pop(0)
                for i in range(curr+1, min(n, curr+nums[curr]+1)):
                    if i not in vis:
                        q.append(i)
                        vis.add(i)
                    if i>=n-1:
                        return step
            step+=1
        return step


# class Solution:
#     def jump(self, nums: List[int]) -> int:
#         n = len(nums)
#         dp = [0]*n
#         for i in range(n-2, -1, -1):
#             ans = float('inf')
#             for j in range(i+1, min(n, i+nums[i]+1)):
#                 ans = min(ans, dp[j]+1)
#             dp[i] = ans
#         return dp[0]


# class Solution:
#     def jump(self, nums: List[int]) -> int:
#         def find(ptr):
#             if ptr>=n-1: return 0
#             if memo[ptr]==None:
#                 memo[ptr]=float('inf')
#                 for i in range(nums[ptr]):
#                     memo[ptr] = min(memo[ptr], find(1+i+ptr)+1)
#             return memo[ptr]
        
#         n = len(nums)
#         memo = [None]*n
#         return find(0)


# class Solution:
#     def jump(self, nums: List[int]) -> int:
#         def find(ptr):
#             if ptr>=len(nums)-1:
#                 return 0
#             if memo[ptr]!=None:
#                 return memo[ptr]
#             memo[ptr]=float('inf')
#             for i in range(nums[ptr]):
#                 memo[ptr] = min(memo[ptr], find(1+i+ptr)+1)
#             return memo[ptr]
        
#         memo = [None]*len(nums)
#         return find(0)