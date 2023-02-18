class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        
        def find(i):
            while par[i] != i:
                i = par[i]
            return i
            
        
        n = len(isConnected)
        par = [i for i in range(n+1)]
        
        for i in range(n):
            for j in range(n):
                if isConnected[i][j] and i!=j:
                    find_a, find_b = find(i+1), find(j+1)
                    if find_a != find_b:
                        par[find_b] = par[find_a]
        
        return len(set([find(i) for i in range(1, n+1)]))