class Solution:
    def dailyTemperatures(self, temp: List[int]) -> List[int]:
        stk=[]
        ans=[0]*(len(temp))
        
        i=len(temp)-1
        while i>=0:
            while stk and stk[-1][0] <= temp[i]:
                stk.pop()
            if stk:
                ans[i] = stk[-1][1]-i
            stk.append((temp[i], i))
            i-=1
        
        return ans
            
        