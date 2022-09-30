class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        i, j, ans = 0, 1, 1
        while j<len(nums) and i<len(nums):
            if nums[i]==nums[j]: j+=1
            else:
                i+=1
                nums[i]=nums[j]
                j+=1
                ans+=1
        return ans