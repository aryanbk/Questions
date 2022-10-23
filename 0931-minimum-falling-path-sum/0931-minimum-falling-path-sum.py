class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        l=len(matrix)
        prev = [matrix[-1][i] for i in range(l)]
        
        for row in range(l-1, -1, -1):
            curr = [0]*l
            for col in range(l):
                if row<l-1:
                    curr[col] = prev[col]
                    if col>0:
                        curr[col] = min(curr[col], prev[col-1])
                    if col<l-1:
                        curr[col] = min(curr[col], prev[col+1])
                curr[col] += matrix[row][col]
            prev = curr
        return min(prev)



# class Solution:
#     def minFallingPathSum(self, matrix: List[List[int]]) -> int:
#         l=len(matrix)
#         dp = [[0]*l for _ in range(l)]
        
#         for row in range(l-1, -1, -1):
#             for col in range(l):
#                 if row<l-1:
#                     dp[row][col] = dp[row+1][col]
#                     if col>0:
#                         dp[row][col] = min(dp[row][col], dp[row+1][col-1])
#                     if col<l-1:
#                         dp[row][col] = min(dp[row][col], dp[row+1][col+1])
#                 dp[row][col] += matrix[row][col]
        
#         return min(dp[0])
        
        

# class Solution:
#     def minFallingPathSum(self, matrix: List[List[int]]) -> int:
#         def fall(row, col):
#             if not 0<=col<len(matrix):
#                 return 10**5
#             if row==len(matrix)-1:
#                 return matrix[row][col]
#             return matrix[row][col] + min(fall(row+1, col-1), fall(row+1, col), fall(row+1, col+1))
        
#         res=fall(0, 0)
#         for i in range(1, len(matrix)):
#             res = min(res, fall(0, i))
#         return res