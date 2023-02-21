class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        def solve(i):
            nonlocal res
            if i==0:
                return [1, 1]
            a, b = solve(i-1)
            ans = [max(nums[i-1]*a, nums[i-1]*b, nums[i-1]), min(nums[i-1]*a, nums[i-1]*b, nums[i-1])]
            res = max(res, ans[0])
            return ans if nums[i-1]!=0 else [1, 1]
        
        res = max(nums)
        solve(len(nums))
        return res