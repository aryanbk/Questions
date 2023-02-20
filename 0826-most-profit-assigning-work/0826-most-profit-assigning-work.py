class Solution:
    def maxProfitAssignment(self, diff: List[int], prof: List[int], wrk: List[int]) -> int:
        zipped = sorted(zip(diff, prof))
        for i in range(1, len(diff)):
            zipped[i] = (zipped[i][0], max(zipped[i][1], zipped[i-1][1]))
        
        ans, p = 0, [i[0] for i in zipped]
        
        for w in wrk:
            ind = bisect_right(p, w)
            if ind:
                ans += zipped[ind-1][1]
        return ans

    
# class Solution:
#     def maxProfitAssignment(self, diff: List[int], prof: List[int], wrk: List[int]) -> int:
        
#         q = sorted([(diff[ind], ind) for ind in range(len(diff))])
#         prof = [prof[j] for i,j in q]
#         for i in range(1, len(prof)):
#             prof[i] = max(prof[i-1], prof[i])
        
#         p, ans = [i[0] for i in q], 0
#         for w in wrk:
#             ind = bisect_right(p, w)
#             if ind!=0:
#                 ans += prof[ind-1]
#         return ans
