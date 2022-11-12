class MedianFinder:

    def __init__(self):
        self.lft=[] #maxheap
        self.rgt=[] #minheap

    def addNum(self, num: int) -> None:
        if len(self.rgt)==0:
            heappush(self.rgt, num)
        elif len(self.lft)==len(self.rgt):
            if num <= -self.lft[0]:
                heappush(self.rgt, -heappop(self.lft))
                heappush(self.lft, -num)
            else:
                heappush(self.rgt, num)
        else:
            if num <= self.rgt[0]:
                heappush(self.lft, -num)
            else:
                heappush(self.lft, heappop(self.rgt)*-1)
                heappush(self.rgt, num)

    def findMedian(self) -> float:
        return self.rgt[0] if len(self.rgt)!=len(self.lft) else (self.rgt[0] - self.lft[0])/2


# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()