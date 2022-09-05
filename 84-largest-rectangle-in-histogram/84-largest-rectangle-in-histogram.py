class Solution:
    def largestRectangleArea(self, ht: List[int]) -> int:
        l=len(ht)
        def nsl():
            stk=deque()
            res=[-1]*(l)
            for i in range(l):
                while len(stk)>0 and ht[stk[-1]]>=ht[i]:
                    stk.pop()
                if len(stk)!=0:
                    res[i]=stk[-1]
                stk.append(i)
            return res
                
        def nsr():
            stk=deque()
            res=[l]*(l)
            for i in range(l-1, -1, -1):
                while len(stk)>0 and ht[stk[-1]]>=ht[i]:
                    stk.pop()
                if(len(stk)!=0):
                    res[i]=stk[-1]
                stk.append(i)
            return res
        
        
        
        resl=nsl()
        resr=nsr()
        ans=0
        
        for i in range(l):
            ans=max(ans, (resr[i]-resl[i]-1)*ht[i])
        return ans