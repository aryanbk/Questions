class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        
        mp = [-1]*len(graph)
        q = []
        
        for i in range(len(graph)):
            if mp[i] != -1:
                continue
            q.append([i, 0])
            #BFS
            while q:
                idx, stt = q.pop(0)
                mp[idx] = stt
                stt ^= 1
                for g in graph[idx]:
                    if mp[g]==-1:
                        q.append([g, stt])
                    elif mp[g] != stt:
                        return False

        return True
        

# class Solution:
#     def isBipartite(self, graph: List[List[int]]) -> bool:
#         def dfs(ind, stamp):
#             if mp[ind]!=None:
#                 return mp[ind]==stamp
#             mp[ind]=stamp
#             res=True
#             for i in graph[ind]:
#                 res = res and dfs(i, not stamp)
#             return res
        
#         mp=[None]*len(graph)
#         for i in range(len(mp)):
#             if mp[i]==None and dfs(i, True)==False:
#                 return False
#         return True