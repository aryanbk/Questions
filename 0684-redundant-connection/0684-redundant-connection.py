class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        n = len(edges)
        par = [i for i in range(n+1)]
        
        def find(i):
            while par[i]!=i:
                i=par[i]
            return i
        
        for a,b in edges:
            find_a, find_b = find(a), find(b)
            if find_a != find_b:
                par[find_b] = par[find_a]
            else:
                return [a,b]
            
        return [-1, -1]
                