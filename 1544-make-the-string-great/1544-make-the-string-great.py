class Solution:
    def makeGood(self, s: str) -> str:
        stk = []
        for c in s:
            if stk and abs(ord(stk[-1]) - ord(c)) == 32:
                stk.pop()
            else:
                stk.append(c)
        return "".join(stk)
        
        
        
        
# class Solution:
#     def makeGood(self, s: str) -> str:
#         for i in range(len(s)-1):
#             if abs(ord(s[i]) - ord(s[i+1])) == 32:
#                 return self.makeGood(s[:i]+s[i+2:])
#         return s