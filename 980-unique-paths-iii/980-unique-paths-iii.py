class Solution:
    def uniquePathsIII(self, grid: List[List[int]]) -> int:
        def bk(i, j, min_one):
            if i<0 or j<0 or i>=len(grid) or j>=len(grid[0]) or grid[i][j]==-1:
                return 0
            if grid[i][j]==2:
                return 1 if len(grid)*len(grid[0])==1+min_one else 0
            
            grid[i][j]=-1
            res=bk(i+1, j, min_one+1)+bk(i, j+1, min_one+1)+ bk(i-1, j, min_one+1) + bk(i, j-1, min_one+1)
            grid[i][j]=0
            return res
        
        sti, stj, minus_one = 0,0,0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]==-1:
                    minus_one+=1
                if grid[i][j]==1:
                    sti=i
                    stj=j
        return bk(sti, stj, minus_one)
        