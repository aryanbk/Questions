```
class Solution:
def minimumTotal(self, triangle: List[List[int]]) -> int:
l = len(triangle)
dp = triangle[-1]
for row in range(l-2, -1, -1):
for col in range(0, row+1):
dp[col] = triangle[row][col] + min(dp[col], dp[col+1])
return dp[0]
​
# class Solution:
#     def minimumTotal(self, triangle: List[List[int]]) -> int:
#         l = len(triangle)
#         memo = [[0 for j in range(i+1)] for i in range(l)]
#         for row in range(l-1, -1, -1):
#             for col in range(0, row+1):
#                 memo[row][col] = triangle[row][col]
#                 if row+1<l:
#                     memo[row][col] += min(memo[row+1][col], memo[row+1][col+1])
#         return memo[0][0]
​
# class Solution:
#     def minimumTotal(self, triangle: List[List[int]]) -> int:
#         def findmin(i, j):
#             if i == len(triangle)-1:
#                 return triangle[i][j]
#             if memo[i][j]==-1:
#                 memo[i][j] = triangle[i][j] + min(findmin(i+1, j), findmin(i+1, j+1))
#             return memo[i][j]
#         memo = [[-1 for j in range(i+1)] for i in range(len(triangle))]
#         return findmin(0, 0)
```