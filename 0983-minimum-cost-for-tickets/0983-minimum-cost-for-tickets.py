class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        
        def recur(d):
            while d>0 and year[d]==False: d-=1
            if d<=0: return 0
            if dp[d]!=-1: return dp[d]
            dp[d] = min(costs[0]+recur(d-1), costs[1]+recur(d-7), costs[2]+recur(d-30))
            return dp[d]
        
        year = [False]*366
        for i in days: year[i]=True
        dp = [-1]*366
        return recur(365)