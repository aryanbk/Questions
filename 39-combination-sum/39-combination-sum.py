class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        ans=[]
        def dfs(i, total, collection):
            if total==target:
                ans.append(collection.copy())
                return
            if total>target or i>=len(candidates):
                return
            collection.append(candidates[i])
            dfs(i, total+candidates[i], collection)
            collection.pop()
            dfs(i+1, total, collection)
        
        dfs(0, 0, [])
        return ans