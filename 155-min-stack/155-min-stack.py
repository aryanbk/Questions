class MinStack:

    def __init__(self):
        self.stk=[]
        self.mini=0

    def push(self, val: int) -> None:
        if len(self.stk)==0:
            self.stk.append(val)
            self.mini=val
            return
        if val>=self.mini:
            self.stk.append(val)
            return
        self.stk.append(2*val - self.mini)
        self.mini=val
        return

    def pop(self) -> None:
        if self.stk[-1]<self.mini:
            self.mini=2*self.mini - self.stk.pop()
            return
        self.stk.pop()

    def top(self) -> int:
        if self.stk[-1]<self.mini:
            return self.mini
        return self.stk[-1]
        
    def getMin(self) -> int:
        return self.mini

    
    
#     def __init__(self):
#         self.stk=[]
#         self.stk2=[]
#     def push(self, val: int) -> None:
#         self.stk.append(val)
#         if len(self.stk2)==0 or val<=self.stk2[-1]:
#             self.stk2.append(val)
#     def pop(self) -> None:
#         if len(self.stk)>0 and self.stk.pop()==self.stk2[-1]:
#             self.stk2.pop()
#     def top(self) -> int:
#         return self.stk[-1]
#     def getMin(self) -> int:
#         return self.stk2[-1]
    
    
#     def __init__(self):
#         self.stk=[]
#         self.stk2=[]
#     def push(self, val: int) -> None:
#         self.stk.append(val)
#         if len(self.stk2)==0 or val<self.stk2[-1][0]:
#             self.stk2.append([val,len(self.stk)])
#     def pop(self) -> None:
#         if len(self.stk)>0 and self.stk.pop()==self.stk2[-1][0] and len(self.stk)<self.stk2[-1][1]:
#             self.stk2.pop()
#     def top(self) -> int:
#         return self.stk[-1]
#     def getMin(self) -> int:
#         return self.stk2[-1][0]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()