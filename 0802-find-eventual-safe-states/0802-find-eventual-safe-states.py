# Topological sort BFS
# taking edges reversed

class Solution:
    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
        q, indg, outd = [], [0]*len(graph), [[None] for _ in range(len(graph))]
        for i,v in enumerate(graph):
            for j in v:
                if outd[j]==[None]:
                    outd[j]=[i]
                else:
                    outd[j].append(i)
            indg[i]=len(v)
            if len(v)==0:
                q.append(i)
        ans = []
        while q:
            node =q.pop(0)
            ans.append(node)
            
            if outd[node]==[None]:
                continue
            for i in outd[node]:
                indg[i]-=1
                if indg[i]==0:
                    q.append(i)
        return sorted(ans)
        
# DFS
# class Solution:
#     def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
#         n = len(graph)
#         vis1 = vis2 = [False]*n
#         safe = [None]*n
        
#         def isSafe(idx):
#             if safe[idx]!=None:
#                 return safe[idx]
            
#             vis1[idx]=True
#             vis2[idx]=True
#             for node in graph[idx]:
#                 if vis2[node]:
#                     return False
#                 if not vis1[node]:
#                     if not isSafe(node):
#                         return False
            
#             vis2[idx]=False
#             safe[idx]=True
#             return safe[idx]
        
#         ans=[]
#         for i in range(n):
#             if isSafe(i):
#                 ans.append(i)
#         return ans


# class Solution:
#     def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
#         n = len(graph)
#         vis1 = vis2 = [False]*n
#         safe = [None]*n
        
        
#         def isSafe(idx):
#             if safe[idx]!=None:
#                 return safe[idx]
#             if vis2[idx]:
#                 return False
#             if vis1[idx]:
#                 return True
            
#             vis1[idx]=True
#             vis2[idx]=True
#             res=True
#             for node in graph[idx]:
#                 res = res and isSafe(node)
            
#             vis2[idx]=False
#             safe[idx]=res
#             return safe[idx]
        
#         ans=[]
#         for i in range(n):
#             if isSafe(i):
#                 ans.append(i)
#         return ans
        