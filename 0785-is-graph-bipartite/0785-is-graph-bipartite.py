class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        def dfs(ind, stamp):
            if mp[ind]!=None:
                return mp[ind]==stamp
            mp[ind]=stamp
            res=True
            for i in graph[ind]:
                res = res and dfs(i, not stamp)
            return res
        
        n=len(graph)
        mp=[None]*n
        ans=True
        for i in range(n):
            if mp[i]==None:
                ans = ans and dfs(i, True)
                if not ans:
                    return ans
        return ans