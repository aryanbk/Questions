class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [0]*n
        dp[0] = 1
        
        for i in range(m):
            curr = [0]*n
            for j in range(n):
                curr[j] = dp[j]
                if j > 0:
                    curr[j] += curr[j-1]
            dp = curr
        return dp[n-1]


# class Solution:
#     def uniquePaths(self, m: int, n: int) -> int:
#         dp=[[-1]*n for _ in range(m)]
        
#         for i in range(m):
#             for j in range(n):
#                 if not (i==0 and j==0):
#                     up = left = 0
#                     if j>0:
#                         left = dp[i][j-1]
#                     if i>0:
#                         up = dp[i-1][j]
#                     dp[i][j] = up+left
#                 else:
#                     dp[i][j] = 1
#         return dp[m-1][n-1]
        
        
# class Solution:
#     def uniquePaths(self, m: int, n: int) -> int:
#         dp = [[-1]*(n+1) for _ in range(m+1)]
        
#         for i in range(m+1):
#             dp[i][n]=0
#         for i in range(n+1):
#             dp[m][i] = 0
#         dp[m-1][n] = 1
        
#         for i in range(m-1, -1, -1):
#             for j in range(n-1, -1, -1):
#                 dp[i][j] = dp[i+1][j] + dp[i][j+1]
        
#         return dp[0][0]
        
        

# class Solution:
#     def uniquePaths(self, m: int, n: int) -> int:
#         def move(i, j):
#             nonlocal m,n
#             if 0<=i<m and 0<=j<n:
#                 if memo[i][j] == -1:
#                     memo[i][j] = move(i+1, j) + move(i, j+1)
#                 return memo[i][j]
#             return 0
        
#         memo = [[-1]*n for _ in range(m)]
#         memo[-1][-1] = 1
#         return move(0, 0)

        