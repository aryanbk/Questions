class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        n = len(nums)
        left = right = pos = 0
        while right<n:
            while right<n and nums[left]==nums[right]:
                right+=1
            if right-left<3:
                while left<right:
                    nums[pos] = nums[left]
                    pos+=1
                    left+=1
            else:
                for i in range(2): nums[pos+i] = nums[left+i]
                pos += 2
                left = right
        return pos