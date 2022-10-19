class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        adj = collections.defaultdict(list)
        for u,v,w in times:
            adj[u].append((v, w))
        
        minhp, vis, t = [(0, k)], set(), 0
        
        while minhp:
            tm, node = heappop(minhp)
            if node in vis:
                continue
            vis.add(node)
            t = tm
            
            for n2, t2 in adj[node]:
                if n2 not in vis:
                    heappush(minhp, (tm+t2, n2))
        
        return t if len(vis)==n else -1