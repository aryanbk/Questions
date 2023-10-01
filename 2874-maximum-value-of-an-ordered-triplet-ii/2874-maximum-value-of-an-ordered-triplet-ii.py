class Solution:
    def maximumTripletValue(self, nums: List[int]) -> int:
        l=len(nums)
        f=[-1]*l
        f[0] = nums[0]
        for i in range(1, l):
            mx = max(f[i-1], nums[i])
            f[i] = mx
        
        mx = nums[-1]
        ans = 0
        
        for i in range(l-2, 0, -1):
            ans = max(ans, (f[i-1]-nums[i])*mx)
            mx = max(mx, nums[i])
        
        return ans