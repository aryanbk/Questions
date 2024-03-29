class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n=len(nums)
        suff = [1]*n
        for i in range(n-2, -1, -1):
            suff[i] = suff[i+1]*nums[i+1]
        curr = 1
        for i in range(n):
            suff[i] *= curr
            curr*=nums[i]
        return suff