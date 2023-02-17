class Solution:
    def maxDistToClosest(self, seats: List[int]) -> int:
        n = len(seats)
        dis = [float('inf') for i in seats]
        for i in range(n-1, -1, -1):
            if i==n-1 and seats[i]:
                dis[i] = 0
            elif i<n-1:
                dis[i] = 0 if seats[i] else dis[i+1]+1
        
        ans = -float('inf')
        curr = float('inf')
        for i in range(n):
            curr = 0 if seats[i] else curr+1
            ans = max(ans, min(curr, dis[i]))
        return ans
            
            