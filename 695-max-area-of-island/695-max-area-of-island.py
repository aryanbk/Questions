class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        row, col, ans = len(grid), len(grid[0]), -1
        def area(i, j):
            if i<0 or j<0 or i>=row or j>=col or grid[i][j]==0:
                return 0;
            grid[i][j]=0
            res= 1+area(i+1, j)+area(i-1, j)+area(i, j+1)+area(i, j-1)
            return res
        
        for x in range(row):
            for y in range(col):
                ans=max(ans, area(x, y))
        return ans
        