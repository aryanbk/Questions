class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m = len(mat)
        n = len(mat[0])
        vis = [[False]*n for _ in range(m)]
        q = []
        drxn = [0, 1, 0, -1, 0]
        
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    vis[i][j] = True
                    q.append((i, j, 0))
                    
        while q:
            i, j, d = q.pop(0)
            mat[i][j] = d
            for f in range(4):
                x = i+drxn[f]
                y = j+drxn[f+1]
                if x>=0 and x<m and y>=0 and y<n and not vis[x][y]:
                    vis[x][y] = True
                    q.append((x, y, d+1))
        
        return mat

        
        
        
##################################################################################

# class Solution:
#     def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        
#         # def bfs(i, j):
#         #     if (i, j) in memo:
#         #         return memo[(i, j)]
#         #     vis = [[False]*len(mat[0]) for i in range(len(mat))]
#         #     q = deque()
#         #     q.append([i, j, 0])
#         #     while q:
#         #         i, j, d = q.popleft()
#         #         if mat[i][j]==0:
#         #             memo[(i, j)] = d
#         #             return d
#         #         vis[i][j]=True
#         #         d+=1
#         #         for x in directn:
#         #             if not (i+x[0]<0 or j+x[1]<0 or i+x[0]>=len(mat) or j+x[1]>=len(mat[0]) or vis[i+x[0]][j+x[1]]):
#         #                 q.append([i+x[0], j+x[1], d])
        
#         def dfs(i, j, vis):
#             if 0==mat[i][j]:
#                 return 0
#             if ans[i][j] != 0:
#                 return ans[i][j]
#             res = float('inf')
#             for x,y in directn:
#                 if i+x>=0 and i+x<m and j+y>=0 and j+y<n and (i+x, j+y) not in vis:
#                     vis.add((i+x, j+y))
#                     res = min(res, dfs(i+x, j+y, vis)+1)
            
#             ans[i][j] = res
#             return res
        
        
#         m = len(mat)
#         n = len(mat[0])
#         ans = [[0]*n for _ in range(m)]
#         directn = [[1,0], [0,1], [-1, 0], [0,-1]]
#         for i in range(len(mat)):
#             for j in range(len(mat[0])):
#                 if mat[i][j]==1:
#                     dfs(i, j, set([(i, j)]))
#         # print(memo)
#         print(ans)
#         return ans