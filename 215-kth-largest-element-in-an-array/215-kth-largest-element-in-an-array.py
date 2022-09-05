class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        h=[]
        for i in range(len(nums)):
            heapq.heappush(h, nums[i]);
            if len(h)>k:
                heapq.heappop(h)
        return h[0]