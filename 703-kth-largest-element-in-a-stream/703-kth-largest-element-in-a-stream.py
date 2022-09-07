class KthLargest:

    def __init__(self, k: int, nums: List[int]):
        self.hp=nums
        self.k=k
        heapify(self.hp)
        while len(self.hp)>k:
            heappop(self.hp)
        return

    def add(self, val: int) -> int:
        heappush(self.hp, val)
        if len(self.hp)>self.k:
            heappop(self.hp)
        return self.hp[0]
        


# Your KthLargest object will be instantiated and called as such:
# obj = KthLargest(k, nums)
# param_1 = obj.add(val)