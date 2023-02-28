class Solution:
    def maxDistance(self, pos: List[int], m: int) -> int:
        
        def allocate(mid):
            ball = 1
            last = pos[0]
            for i in range(1, len(pos)):
                if pos[i]-last>=mid:
                    ball+=1
                    last = pos[i]
            return ball
        
        
        pos.sort()
        lo, hi, res = 1, pos[-1], 1
        
        
        while lo<=hi:
            mid = (lo+hi)//2
            
            ball = allocate(mid)
            if ball>=m:
                res = mid
                lo = mid + 1
            else:
                hi = mid -1
        
        return res