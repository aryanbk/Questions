class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        st, end = 0, len(nums)-1
        while st <= end:
            mid=int(st+(end-st)/2)
            if nums[mid]==target:
                i,j=mid, mid
                while i>=0 and nums[i]==target:
                    i-=1
                while j<len(nums) and nums[j]==target:
                    j+=1
                return [i+1, j-1]
            elif nums[mid]<target:
                st=mid+1
            else:
                end=mid-1
        return [-1,-1]
        