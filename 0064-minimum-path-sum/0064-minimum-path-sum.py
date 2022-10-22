class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        def findpath(i, j):
            nonlocal m,n
            if i==0 and j==0:
                return grid[i][j]
            elif 0<=i<m and 0<=j<n:
                if memo[i][j]==-1:
                    memo[i][j] = min(findpath(i-1, j), findpath(i, j-1)) + grid[i][j]
                return memo[i][j]
            return 10**7
        
        m,n = len(grid), len(grid[0])
        memo = [[-1]*n for _ in range(m)]
        return findpath(m-1, n-1)