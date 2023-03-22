class Solution:
    def minScore(self, num: int, roads: List[List[int]]) -> int:
        adj = defaultdict(list)
        for i, j, v in roads:
            adj[i].append([j, v, 0])
            adj[j].append([i, v, 0])
        
        def dfs(node):
            nonlocal ans, flag
            
            if node==1:
                if flag: return
                else: flag=True
        
            for i in range(len(adj[node])):
                n, v, c = adj[node][i]
                if c<2:
                    ans = min(ans, v)
                    adj[node][i][2] += 1
                    if len(adj[n])>1:
                        dfs(n)
            return
        
        ans=float('inf')
        flag=False
        dfs(1)
        return ans