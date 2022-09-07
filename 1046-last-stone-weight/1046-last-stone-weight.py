class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        for i in range(len(stones)):
            stones[i]*=-1
        heapify(stones)
        while len(stones)>1:
            x=heappop(stones)
            y=heappop(stones)
            if x!=y:
                heappush(stones, abs(x-y)*-1)
        return heappop(stones)*(-1) if len(stones)>0 else 0
        