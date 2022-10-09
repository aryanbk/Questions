class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        
        def bk(o, c, strg, stk):
            if o==c==0 and not stk:
                ans.append(strg[:])
                return
            
            if o:
                strg+="("
                stk.append('(')
                bk(o-1, c, strg, stk)
                strg=strg[:-1]
                stk.pop()
            if c and stk:
                strg+=")"
                temp=stk.pop()
                bk(o, c-1, strg, stk)
                strg=strg[:-1]
                stk.append(temp)
            
            
        ans=[]
        bk(n, n , "", [])
        return ans
        