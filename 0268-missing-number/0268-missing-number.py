class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        ans=len(nums)
        for i,v in enumerate(nums): ans ^= i^v
        return ans