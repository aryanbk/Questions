class SmallestInfiniteSet:

    def __init__(self):
        self.curr=1
        self.h=[]

    def popSmallest(self) -> int:
        if self.h and self.h[0] <= self.curr:
            return heappop(self.h)
        else:
            self.curr += 1
            return self.curr-1
        

    def addBack(self, num: int) -> None:
        if num<self.curr and not (num in self.h):
            heappush(self.h, num)


# Your SmallestInfiniteSet object will be instantiated and called as such:
# obj = SmallestInfiniteSet()
# param_1 = obj.popSmallest()
# obj.addBack(num)