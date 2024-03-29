class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        adj = collections.defaultdict(list)
        for u,v,c in flights:
            adj[u].append((v, c))
        vis, q = [float('inf')]*n, deque([(0, 0, src)])
        
        while q:
            k0, curr, node = q.popleft()
            if node==dst:
                vis[dst] = min(vis[dst], curr)
                continue
            if k0>k or vis[node]<curr:
                #cause all the cost less than curr has smaller k value also so that's better than this curr
                continue
            vis[node]=min(vis[node], curr)
            for v, c in adj[node]:
                q.append((k0+1, curr+c, v))
                
        return vis[dst] if vis[dst]!=float('inf') else -1
        
        
# class Solution:
#     def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
#         adj = collections.defaultdict(list)
#         for u,v,c in flights:
#             adj[u].append((v, c))
        
#         vis = [[math.inf]*(k+2) for _ in range(n)]
#         minhp = [(0, 0, src)]
        
#         while minhp:
#             curr, k0, node = heappop(minhp)
            
#             if node==dst and k0>k+1:
#                 continue
#             if node!=dst and k0>k:
#                 continue

#             i=0
#             while i<=k0:
#                 if vis[node][i] <= curr:
#                     break
#                 i+=1
#             if i!=k0+1:
#                 continue
#             vis[node][k0] = curr
            
            
#             for v, c in adj[node]:
#                 heappush(minhp, (curr+c, k0+1, v))
                
#         ans = min(vis[dst])
#         return ans if ans!=math.inf else -1
        