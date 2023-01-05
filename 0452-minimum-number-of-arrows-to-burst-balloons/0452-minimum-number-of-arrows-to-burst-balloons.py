class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        points.sort()
        st=points[-1][0]
        ans=0
        for i in range(len(points)-2, -1, -1):
            if points[i][1]>=st:
                continue
            else:
                ans+=1
                st=points[i][0]
        return ans+1