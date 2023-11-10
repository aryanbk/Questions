class Solution:
    def restoreArray(self, adjacentPairs: List[List[int]]) -> List[int]:
        
        def bfs(node):
            ans = []
            q=[(node, None)]
            
            while q:
                curr, prev = q.pop(0)
                ans.append(curr)
                for nbr in adj[curr]:
                    if nbr != prev:
                        q.append((nbr, curr))
            
            return ans
                
                
        
        adj = defaultdict(list)
        
        for a,b in adjacentPairs:
            adj[a].append(b)
            adj[b].append(a)
        
        for k,v in adj.items():
            if len(v)==1:
                return bfs(k)