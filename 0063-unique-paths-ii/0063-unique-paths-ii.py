class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        m, n = len(obstacleGrid), len(obstacleGrid[0])
        prev = [0]*n
        prev[-1] = 1
        
        for i in range(m-1, -1, -1):
            curr = [0]*n
            for j in range(n-1, -1, -1):
                if obstacleGrid[i][j] == 0:
                    curr[j]=prev[j]
                    if j<n-1:
                        curr[j]+=curr[j+1]
                else:
                    curr[j] = 0
            prev = curr
        
        return prev[0]
            