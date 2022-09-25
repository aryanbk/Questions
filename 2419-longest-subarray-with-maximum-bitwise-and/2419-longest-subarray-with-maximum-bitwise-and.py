class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        mx, ans, i = max(nums), 1, 0
        while i<len(nums):
            j=i+1
            if nums[i]==mx:
                while j<len(nums) and mx==nums[j]: j+=1
                ans=max(ans, j-i)
            i=j
        return ans



# contest

# class Solution:
#     def longestSubarray(self, nums: List[int]) -> int:
#         mx=max(nums)
#         ans, i = 1, 0
#         while i<len(nums):
#             lastmx=i+1
#             if nums[i]==mx:
#                 nd=mx
#                 for j in range(i+1, len(nums)):
#                     if nums[j]==mx: lastmx=j
#                     nd = nd & nums[j]
#                     if nd>=mx:
#                         ans=max(ans, j-i+1)
#                     else:
#                         break
#             i=lastmx
#         return ans
        