class Solution:
    def minOperations(self, nums: List[int], x: int) -> int:
        x=sum(nums)-x
        if x==0: return len(nums)
        i, j, sumt, ans = 0, 0, 0, 0
        while j<len(nums) and i<len(nums):
            sumt+=nums[j]
            if sumt<x:
                j+=1
            elif sumt==x:
                ans=max(ans, j-i+1)
                j+=1
            else:
                sumt-=nums[i]
                i+=1
                sumt-=nums[j]
        return len(nums)-ans if ans!=0 else -1




# class Solution:
#     def minOperations(self, nums: List[int], x: int) -> int:
#         x = sum(nums)-x
#         if x==0: return len(nums)
#         i, j, sumt, ans = 0,0, nums[0], 0
#         while j<len(nums) and i<len(nums):
#             while sumt>=x and i<len(nums):
#                 if sumt==x: ans= max(ans, j-i+1)
#                 sumt-=nums[i]
#                 i+=1
#             else:
#                 j+=1
#                 if j<len(nums): sumt+=nums[j]
#         return len(nums)-ans if ans!=0 else -1
        