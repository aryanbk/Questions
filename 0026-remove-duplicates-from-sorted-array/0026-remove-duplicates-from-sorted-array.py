class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        i, j, ans = 0, 1, 1
        while j<len(nums):
            if nums[i]!=nums[j]:
                i+=1
                nums[i]=nums[j]
                ans+=1
            j+=1
        return ans