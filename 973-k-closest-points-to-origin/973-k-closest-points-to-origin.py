class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        hp = []
        for i in range(len(points)):
            heappush(hp, [(points[i][0]**2 + points[i][1]**2)*-1, i])
            if len(hp)>k:
                heappop(hp)
        ans=[]
        while len(hp)>0:
            ans.append(points[heappop(hp)[1]])
        return ans