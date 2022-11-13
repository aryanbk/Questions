class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stk=[]
        for i in tokens:
            if i in ("+", "-", "*", "/"):
                b=stk.pop()
                a=stk.pop()
                if i=="+":
                    stk.append(a+b)
                if i=="-":
                    stk.append(a-b)
                if i=="*":
                    stk.append(a*b)
                if i=="/":
                    c=a/b
                    if c>=0:
                        stk.append(math.floor(c))
                    else:
                        stk.append(math.ceil(c))
            else:
                stk.append(int(i))
        return stk[-1]