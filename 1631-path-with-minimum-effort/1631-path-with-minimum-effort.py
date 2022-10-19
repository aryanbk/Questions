class Solution:
    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        m, n = len(heights), len(heights[0])
        minhp, effort = [(0, 0, 0)], [[math.inf]*n for _ in range(m)]
        dirct = [(1,0), (0,1), (-1,0), (0,-1)]
        
        while minhp:
            eff, i, j = heappop(minhp)
            if eff > effort[i][j]:
                continue
            effort[i][j] = eff
            
            for dx,dy in dirct:
                x, y = i+dx, j+dy
                if 0<=x<m and 0<=y<n:
                    eff2 = max(eff, abs(heights[i][j]-heights[x][y]))
                    if eff2<effort[x][y]:
                        effort[x][y] = eff2
                        heappush(minhp, (eff2, x, y))
        
        return effort[-1][-1]