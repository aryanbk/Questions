class MinStack:

    def __init__(self):
        self.stk=[]
        self.stk2=[]

    def push(self, val: int) -> None:
        self.stk.append(val)
        if len(self.stk2)==0 or val<self.stk2[-1][0]:
            self.stk2.append([val,len(self.stk)])

    def pop(self) -> None:
        if len(self.stk)>0 and self.stk.pop()==self.stk2[-1][0] and len(self.stk)<self.stk2[-1][1]:
            self.stk2.pop()

    def top(self) -> int:
        return self.stk[-1]
        

    def getMin(self) -> int:
        return self.stk2[-1][0]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()