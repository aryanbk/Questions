class Solution:
    def smallestDivisor(self, nums: List[int], thr: int) -> int:
        lo, hi, res = 1, max(nums), 0
        
        while lo<=hi:
            mid = (lo+hi)//2
            sumt=0
            for n in nums: sumt += (n+mid-1)//mid
            
            if sumt<=thr:
                res = mid
                hi = mid - 1
            else:
                lo = mid + 1
        
        return res