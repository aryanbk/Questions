class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        hp = []
        for i in range(len(arr)):
            heappush(hp, [(-1)*abs(arr[i]-x), i*(-1)])
            if len(hp)>k:
                heappop(hp)
        ans = []
        while len(hp)>0:
            ans.append(arr[heappop(hp)[1]*-1])
        return sorted(ans)
        