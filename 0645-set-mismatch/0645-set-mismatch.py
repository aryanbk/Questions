class Solution:
    def findErrorNums(self, nums: List[int]) -> List[int]:
        s=set([i for i in range(1, len(nums)+1)])
        ans=[-1, -1]
        for i in range(len(nums)):
            if nums[i] in s:
                s.remove(nums[i])
            else:
                ans[0]=nums[i]
        ans[1]=s.pop()
        return ans