class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        ans=[]
        nums.sort()
        
        def dfs(i, subset):
            if i==len(nums):
                ans.append(subset.copy())
                return
            subset.append(nums[i])
            dfs(i+1, subset)
            subset.pop()
            j=i
            while j<len(nums) and nums[i]==nums[j]:
                j+=1
            dfs(j, subset)
            
        dfs(0, [])
        return ans
        