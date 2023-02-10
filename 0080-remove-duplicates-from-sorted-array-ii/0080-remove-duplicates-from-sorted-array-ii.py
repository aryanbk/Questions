class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        n = len(nums)
        left = right = pos = 0
        while right<n:
            while right<n and nums[left]==nums[right]: right+=1
            if right-left<3:
                while left<right:
                    nums[pos] = nums[left]
                    pos+=1
                    left+=1
            else:
                nums[pos], nums[pos+1] = nums[left], nums[left+1]
                pos += 2
                left = right
        return pos