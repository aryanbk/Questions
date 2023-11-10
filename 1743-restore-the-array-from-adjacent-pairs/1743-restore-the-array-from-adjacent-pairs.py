class Solution:
    def restoreArray(self, adjacentPairs: List[List[int]]) -> List[int]:
        
        def make(node):
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
        in_deg = defaultdict(int)
        
        for a,b in adjacentPairs:
            in_deg[a]+=1
            in_deg[b]+=1
            
            adj[a].append(b)
            adj[b].append(a)
        
        for k,v in in_deg.items():
            if v==1:
                return make(k)