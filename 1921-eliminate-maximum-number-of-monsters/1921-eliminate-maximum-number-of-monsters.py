class Solution:
    def eliminateMaximum(self, dist: List[int], speed: List[int]) -> int:
        n = len(dist)
        time = [dist[i]/speed[i] for i in range(n)]
        time.sort()
        
        curr = 0
        for i in range(n):
            if(curr>=time[i]):
                return i
            curr+=1
        return n