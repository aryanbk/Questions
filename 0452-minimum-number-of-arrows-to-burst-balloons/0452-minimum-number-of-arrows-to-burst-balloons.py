class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        points.sort()
        start, l, ans = points[-1][0], len(points), 0
        for i in range(l-2, -1, -1):
            if points[i][1]<start:
                start = points[i][0]
                ans += 1
        return ans+1




# class Solution:
#     def findMinArrowShots(self, points: List[List[int]]) -> int:
#         points.sort()
#         st=points[-1][0]
#         ans=0
#         for i in range(len(points)-2, -1, -1):
#             if points[i][1]>=st:
#                 continue
#             else:
#                 ans+=1
#                 st=points[i][0]
#         return ans+1