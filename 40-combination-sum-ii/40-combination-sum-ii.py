class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        ans = []
        candidates.sort()
        
        def dfs(i, total, subset):
            if total==target:
                ans.append(subset[::])
                return
            if total>target or i>=len(candidates):
                return
            subset.append(candidates[i])
            dfs(i+1, total+candidates[i], subset)
            subset.pop()
            j=i
            while j<len(candidates) and candidates[j]== candidates[i]:
                j+=1
            dfs(j, total, subset)
            
        dfs(0, 0, [])
        return ans