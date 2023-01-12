class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq = [(v, k) for k,v in Counter(nums).items()]
        hp=[]
        for i in freq:
            heappush(hp, i)
            if len(hp)>k:
                heappop(hp)
        return [k for v,k in hp]
        