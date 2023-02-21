class Solution:
    def singleNonDuplicate(self, nums: List[int]) -> int:
        lo, hi, res = 0, len(nums)-1, -1
        while lo<=hi:
            mid = (lo+hi)//2
            if mid>=0 and nums[mid-1]==nums[mid]:
                mid-=1
            if mid&1:
                hi=mid-1
            else:
                res=mid
                lo=mid+2
        return nums[res]