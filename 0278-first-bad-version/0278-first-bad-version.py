# The isBadVersion API is already defined for you.
# def isBadVersion(version: int) -> bool:

class Solution:
    def firstBadVersion(self, n: int) -> int:
        lo, hi, res = 0, n, -1
        while lo<=hi:
            mid = (lo+hi)//2
            if isBadVersion(mid):
                res = mid
                hi=mid-1
            else:
                lo=mid+1
        return res