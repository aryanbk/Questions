class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        hp = []
        for i in range(len(points)):
            # stored distance with negative sign (since we want maxheap)
            dist = (-1)*(points[i][0]**2 + points[i][1]**2)
            heappush(hp, [dist, i])
            if len(hp)>k:
                heappop(hp)
        ans=[]
        while len(hp)>0:
            ans.append(points[heappop(hp)[1]])
        return ans