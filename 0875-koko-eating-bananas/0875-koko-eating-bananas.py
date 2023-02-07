class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        l, r, = 1, max(piles)
        ans = r
        
        def valid(mid):
            curr=0
            for p in piles:
                curr += ((p)//mid)+1 if p%mid else p//mid
            return curr<=h
        
        while l<=r:
            mid = (l+r)//2
            if valid(mid):
                ans = min(ans, mid)
                r=mid-1
            else:
                l=mid+1
        return ans