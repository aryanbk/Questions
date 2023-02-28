class Solution:
    def minSpeedOnTime(self, dist: List[int], hour: float) -> int:
        
        def find(n):
            t = 0
            for i in range(len(dist)-1):
                t += (dist[i]+n-1)//n
            t += dist[-1]/n
            return t
        
        lo, hi, res = 1, 10000000, -1
        
        while lo<=hi:
            mid = (lo+hi)//2
            if find(mid)<=hour:
                res = mid
                hi = mid - 1
            else:
                lo = mid + 1
        
        return res