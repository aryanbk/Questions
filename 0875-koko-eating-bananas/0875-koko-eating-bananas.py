class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:        
        def valid(mid):
            curr=0
            for p in piles: curr += math.ceil(p/mid)
            return curr<=h
        
        l, r, = 1, max(piles)
        ans = r
        while l<=r:
            mid = (l+r)//2
            if valid(mid):
                ans = min(ans, mid)
                r=mid-1
            else:
                l=mid+1
        return ans