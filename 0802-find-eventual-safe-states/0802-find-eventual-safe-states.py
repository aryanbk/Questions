class Solution:
    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
        n = len(graph)
        vis1 = vis2 = [False]*n
        safe = [None]*n
        
        def isSafe(idx):
            if safe[idx]!=None:
                return safe[idx]
            
            vis1[idx]=True
            vis2[idx]=True
            for node in graph[idx]:
                if vis2[node]:
                    return False
                if not vis1[node]:
                    if not isSafe(node):
                        return False
            
            vis2[idx]=False
            safe[idx]=True
            return safe[idx]
        
        ans=[]
        for i in range(n):
            if isSafe(i):
                ans.append(i)
        return ans


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