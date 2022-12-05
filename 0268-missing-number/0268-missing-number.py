class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        return (len(nums)+1)*len(nums)//2 - sum(nums)


# class Solution:
#     def missingNumber(self, nums: List[int]) -> int:
#         ans=len(nums)
#         for i,v in enumerate(nums): ans ^= i^v
#         return ans