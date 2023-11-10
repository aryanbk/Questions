class Solution:
    def restoreArray(self, adjacentPairs: List[List[int]]) -> List[int]:
        
        def bfs(node):
            ptr=0
            q=[(node, None)]
            
            while q:
                curr, prev = q.pop(0)
                ans[ptr] = curr
                ptr += 1
                for nbr in adj[curr]:
                    if nbr != prev:
                        q.append((nbr, curr))
        
        def dfs(node, prev=None, ptr=0):
            ans[ptr] = node
            for nbr in adj[node]:
                if nbr != prev:
                    dfs(nbr, node, ptr+1)
                
                
        
        adj = defaultdict(list)
        
        for a,b in adjacentPairs:
            adj[a].append(b)
            adj[b].append(a)
        ans = [0]*(len(adjacentPairs)+1)
        for k,v in adj.items():
            if len(v)==1:
                # bfs(k)
                dfs(k)
                return ans