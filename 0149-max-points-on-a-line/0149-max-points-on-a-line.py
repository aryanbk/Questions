class Solution:
    def maxPoints(self, pts: List[List[int]]) -> int:
        ans=1
        for i,(x, y) in enumerate(pts):
            d = defaultdict(int)
            for j in range(i+1, len(pts)):
                slope=(pts[j][1]-y)/(pts[j][0]-x) if pts[j][0]!=x else None
                d[slope]+=1
                ans=max(ans, d[slope]+1)
        return ans
        
        
# class Solution:
#     def maxPoints(self, pts: List[List[int]]) -> int:
        
#         def on_line(i, j, k):
#             if pts[j][0]-pts[i][0]==0:
#                 return pts[k][0]==pts[i][0]
#             if pts[j][1]-pts[i][1]==0:
#                 return pts[k][1]==pts[i][1]
#             return (pts[k][0]-pts[i][0])/(pts[j][0]-pts[i][0])==(pts[k][1]-pts[i][1])/(pts[j][1]-pts[i][1])
        
#         ans=1
#         for i,(x,y) in enumerate(pts):
#             done=set()
#             for j in range(i+1, len(pts)):
#                 if (pts[j][0], pts[j][1]) in done:
#                     continue
#                 satisf=2
#                 for k in range(j+1, len(pts)):
#                     if (pts[k][0], pts[k][1]) not in done and on_line(i, j, k):
#                         satisf+=1
#                         done.add((pts[k][0], pts[k][1]))
#                 ans=max(ans, satisf)
#         return ans
            
        