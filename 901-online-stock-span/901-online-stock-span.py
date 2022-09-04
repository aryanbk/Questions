class StockSpanner:
    def __init__(self):
        self.stk=[]

    def next(self, price: int) -> int:
        ans=1
        if len(self.stk)==0:
            self.stk.append([price, ans])
            return ans
        
        while len(self.stk)>0:
            if self.stk[len(self.stk)-1][0]>price:
                self.stk.append([price, ans])
                return ans
            ans+=self.stk.pop()[1]
        self.stk.append([price, ans])
        return ans


# Your StockSpanner object will be instantiated and called as such:
# obj = StockSpanner()
# param_1 = obj.next(price)