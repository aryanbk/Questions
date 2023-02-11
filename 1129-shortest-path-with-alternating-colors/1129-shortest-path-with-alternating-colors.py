class Solution:
    def shortestAlternatingPaths(self, n: int, red: List[List[int]], blue: List[List[int]]) -> List[int]:
        
        def find(dest):
            q, step, vis = [(0, None)], 1, set()
            while q:
                for _ in range(len(q)):
                    curr, col = q.pop(0)
                    for node, node_col in edge[curr]:
                        if col != node_col and (curr, node,node_col) not in vis:
                            if node == dest: return step
                            q.append((node, node_col))
                            vis.add((curr, node, node_col))
                step+=1
            return -1
        
        
        edge=defaultdict(list)
        for a,b in red: edge[a].append((b, True))
        for a,b in blue: edge[a].append((b, False))
        ans = [0]*n
        for dest in range(1, n): ans[dest] = find(dest)
        return ans

# class Solution:
#     def shortestAlternatingPaths(self, n: int, red: List[List[int]], blue: List[List[int]]) -> List[int]:
        
#         def find(dest):
#             # if dest==0:
#                 # return 0
#             q, step, vis = [(0, None)], 0, set()
            
#             while q:
#                 for _ in range(len(q)):
#                     curr, col = q.pop(0)
#                     if curr==dest: return step
#                     for node, node_col in edge[curr]:
#                         if col != node_col and (curr, node,node_col) not in vis:
#                             if node == dest: return step+1
#                             q.append((node, node_col))
#                             vis.add((curr, node, node_col))
#                 step+=1
#             return -1
        
        
#         edge=defaultdict(list)
#         for a,b in red: edge[a].append((b, True))
#         for a,b in blue: edge[a].append((b, False))
#         ans = [0]*n
#         # for dest in range(1, n): ans[dest] = find(dest)
#         # print(find(0))
#         # return ans
#         return [find(i) for i in range(n)]
            
            