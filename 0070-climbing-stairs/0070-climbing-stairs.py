class Solution:
    def climbStairs(self, n: int) -> int:
        prev, prev2 = 1, 1
        for i in range(n-1):
            prev, prev2 = prev+prev2, prev
        return prev
        
        
        

# class Solution:
#     def climbStairs(self, n: int) -> int:
#         t = [0]*(n+1)
#         t[0] = 1
#         t[1] = 1
        
#         for i in range(2, n+1):
#             t[i] = t[i-1] + t[i-2]
#         return t[n]
        
        
# class Solution:
#     def climbStairs(self, n: int) -> int:
        
#         def climb(step):
#             if step<0:
#                 return 0
#             if memo[step]==-1:
#                 memo[step] = climb(step-1) + climb(step-2)
#             return memo[step]
        
#         memo = [-1]*(n+1)
#         memo[0] = 1
        
#         return climb(n)
        