class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        def findmin(i, j):
            if i == len(triangle)-1:
                return triangle[i][j]
            if memo[i][j]==-1:
                memo[i][j] = triangle[i][j] + min(findmin(i+1, j), findmin(i+1, j+1))
            return memo[i][j]
        
        memo = [[-1 for j in range(i+1)] for i in range(len(triangle))]
        return findmin(0, 0)
        