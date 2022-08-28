class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if len(nums)==1:
            return 0
        smallest = (-2)**31
        def find(i):
            if 0<=i<len(nums):
                return nums[i]
            else:
                return -2**31
        
        lo, hi = 0, len(nums)-1
        while lo<=hi:
            mid=(lo+hi)//2
            if find(mid)>find(mid-1) and find(mid)>find(mid+1):
                return mid;
            elif find(mid)<find(mid+1):
                lo=mid+1
            elif find(mid)<find(mid-1):
                hi=mid-1
        return -1