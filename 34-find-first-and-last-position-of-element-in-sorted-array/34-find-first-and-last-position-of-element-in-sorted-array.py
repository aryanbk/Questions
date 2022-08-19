class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        st, end = 0, len(nums)-1
        first, last= -1, -1
        while st <= end:
            mid=int(st+(end-st)/2)
            if nums[mid]==target:
                first=mid
                end=mid-1
            elif nums[mid]<target:
                st=mid+1
            else:
                end=mid-1
                
        st, end = 0, len(nums)-1
        while st <= end:
            mid=int(st+(end-st)/2)
            if nums[mid]==target:
                last=mid
                st=mid+1
            elif nums[mid]<target:
                st=mid+1
            else:
                end=mid-1
                
        return [first, last]
        