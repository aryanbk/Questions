# Topological sort - using BFS (kahns algorithm)
class Solution:
    def findOrder(self, numCourses: int, prereq: List[List[int]]) -> List[int]:
        indg=[0]*numCourses
        for i in prereq:
            indg[i[1]]+=1
        
        adj = [None]*numCourses
        for i in prereq:
            if adj[i[0]]:
                adj[i[0]].append(i[1])
            else:
                adj[i[0]]=[i[1]]

        q=[]
        for i,v in enumerate(indg):
            if v==0:
                q.append(i)
        
        ans = []
        while q:
            p = q.pop(0)
            ans.append(p)
            
            if adj[p]:
                for node in adj[p]:
                    indg[node]-=1
                    if indg[node]==0:
                        q.append(node)
        return [] if len(ans) != numCourses else ans[::-1]

# Topolodical sort - using DFS
# class Solution:
#     def findOrder(self, numCourses: int, prereq: List[List[int]]) -> List[int]:
        
#         adj = [None]*numCourses
#         for i in prereq:
#             if adj[i[0]]:
#                 adj[i[0]].append(i[1])
#             else:
#                 adj[i[0]]=[i[1]]
        
#         vis1, vis2 = [False]*numCourses, [False]*numCourses
#         flow = [] #Topological sorting
        
#         def dfs(i):
#             if vis2[i]==True:
#                 return False
#             if vis1[i]==True:
#                 return True
            
#             vis1[i]=True
#             vis2[i]=True
#             if adj[i]:
#                 for pre in adj[i]:
#                     if not dfs(pre):
#                         return False
#             vis2[i]=False
#             flow.append(i)
#             return True

#         for i in range(numCourses):
#             if not dfs(i):
#                 return []
#         return flow
        