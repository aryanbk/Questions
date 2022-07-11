class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        ans=[]
        
        def dfs(i, subset):
            if i==len(nums):
                ans.append(subset[::])
                return
            dfs(i+1, subset)
            subset.append(nums[i])
            dfs(i+1, subset)
            subset.pop()
            
        dfs(0, [])
        return ans
        