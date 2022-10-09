class Solution:
    def uniquePathsIII(self, grid: List[List[int]]) -> int:
        
        def isFull():
            for i in range(len(grid)):
                for j in range(len(grid[0])):
                    if grid[i][j]==0:
                        return 0
            return 1
        
        def bk(i, j):
            if i<0 or j<0 or i>=len(grid) or j>=len(grid[0]) or grid[i][j]==-1:
                return 0
            if grid[i][j]==2:
                return isFull()
            
            grid[i][j]=-1
            res=bk(i+1, j)+bk(i, j+1)+ bk(i-1, j) + bk(i, j-1)
            grid[i][j]=0
            return res
        
        
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]==1:
                    return bk(i, j)
        return 0
        