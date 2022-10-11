class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        
        def valid(i, j):
            return not (i<0 or j<0 or i>=m or j>=n or grid[i][j]!=1)
        
        q=[]
        fresh, m , n = 0, len(grid), len(grid[0])
        for i in range(m):
            for j in range(n):
                if grid[i][j]==2:
                    q.append([i, j, 0])
                if grid[i][j]==1:
                    fresh+=1
        time=0
        while q and fresh:
            i, j, t = q.pop(0)
            if grid[i][j]==1:
                fresh-=1
            grid[i][j]=3
            time=max(time, t)
            t+=1
            if valid(i+1, j):
                q.append([i+1, j, t])
            if valid(i, j+1):
                q.append([i, j+1, t])
            if valid(i-1, j):
                q.append([i-1, j, t])
            if valid(i, j-1):
                q.append([i, j-1, t])
        
        return time if fresh==0 else -1