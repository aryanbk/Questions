class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        def dfs(ptr, sub, mp):
            if ptr>=len(nums):
                ans.append(sub.copy())
                return
            for i in range(0, len(nums)):
                if mp[i]:
                    sub.append(nums[i])
                    mp[i]=False
                    dfs(ptr+1, sub, mp)
                    mp[i]=True
                    sub.pop()
        
        ans=[]
        dfs(0, [], [True]*len(nums))
        return ans