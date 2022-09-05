class Solution:
    def kthLargestNumber(self, nums: List[str], k: int) -> str:
        hp = []
        for i in nums:
            heappush(hp, int(i))
            if len(hp)>k:
                heappop(hp)
        return str(hp[0])