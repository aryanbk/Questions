class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        m,n = len(grid), len(grid[0])
        prev = [10**7]*n
        prev[0] = 0
        
        for i in range(m):
            curr = [0]*n
            for j in range(n):
                up=prev[j]
                left = curr[j-1] if j>0 else 10**7
                curr[j]  = min(up, left) + grid[i][j]
            prev = curr
        return prev[-1]

# class Solution:
#     def minPathSum(self, grid: List[List[int]]) -> int:
#         m,n = len(grid), len(grid[0])
#         dp = [[0]*n for _ in range(m)]
#         for i in range(m):
#             for j in range(n):
#                 if i>0 or j>0:
#                     up = left = 10**7
#                     if i>0:
#                         up = dp[i-1][j]
#                     if j>0:
#                         left = dp[i][j-1]
#                     dp[i][j] = min(up, left) + grid[i][j]
#                 elif i==0 and j==0:
#                     dp[i][j] = grid[i][j]
#         print(dp)
#         return dp[-1][-1]
        
        
        
# class Solution:
#     def minPathSum(self, grid: List[List[int]]) -> int:
#         def findpath(i, j):
#             nonlocal m,n
#             if i==0 and j==0:
#                 return grid[i][j]
#             elif 0<=i<m and 0<=j<n:
#                 if memo[i][j]==-1:
#                     memo[i][j] = min(findpath(i-1, j), findpath(i, j-1)) + grid[i][j]
#                 return memo[i][j]
#             return 10**7
        
#         m,n = len(grid), len(grid[0])
#         memo = [[-1]*n for _ in range(m)]
#         return findpath(m-1, n-1)
        
        