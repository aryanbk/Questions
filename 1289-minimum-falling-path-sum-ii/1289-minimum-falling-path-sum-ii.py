# No TLE
# Space optimization + heap
class Solution:
    def minFallingPathSum(self, grid: List[List[int]]) -> int:
        l = len(grid)
        prev, maxhp = [grid[-1][i] for i in range(l)], []
        for i in prev:
            heappush(maxhp, -i)
            if len(maxhp)>2:
                heappop(maxhp)
        
        for row in range(l-2, -1, -1):
            curr = [0]*l
            maxhp2 = []
            for col in range(l):
                curr[col] = -maxhp[1] if -maxhp[1] != prev[col] else -maxhp[0]
                curr[col] += grid[row][col]    
                
                heappush(maxhp2, -curr[col])
                if len(maxhp2)>2:
                    heappop(maxhp2)
            
            prev = curr
            maxhp = maxhp2
        
        return min(prev)


# TLE
# tabulation soln without using heap

# class Solution:
#     def minFallingPathSum(self, matrix: List[List[int]]) -> int:
#         l=len(matrix)
#         dp = [[10**6]*l for _ in range(l)]
        
#         for row in range(l-1, -1, -1):
#             for col in range(l):
#                 if row != l-1:
#                     for i in range(l):
#                         if i!=col:
#                             dp[row][col] = min(dp[row][col], dp[row+1][i])
#                     dp[row][col] += matrix[row][col]
#                 else:
#                     dp[row][col] = matrix[row][col]
        
#         return min(dp[0])