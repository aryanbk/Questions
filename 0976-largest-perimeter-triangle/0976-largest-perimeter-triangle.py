class Solution:
    def largestPerimeter(self, nums: List[int]) -> int:
        nums.sort()
        while len(nums)>2:
            if nums[-2]+nums[-3]>nums[-1]:
                return nums[-1]+nums[-2]+nums[-3]
            else:
                nums.pop()
        return 0