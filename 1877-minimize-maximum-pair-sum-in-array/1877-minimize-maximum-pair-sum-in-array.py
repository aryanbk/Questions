class Solution:
    def minPairSum(self, nums: List[int]) -> int:
        nums.sort()
        mx = -1
        for i in range(len(nums)):
            mx = max(mx, nums[i]+nums[-1-i])
        return mx