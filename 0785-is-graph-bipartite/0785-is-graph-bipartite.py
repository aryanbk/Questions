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
        
        mp=[None]*len(graph)
        for i in range(len(mp)):
            if mp[i]==None and dfs(i, True)==False:
                return False
        return True