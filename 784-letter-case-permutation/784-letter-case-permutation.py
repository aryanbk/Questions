class Solution:
    def letterCasePermutation(self, s: str) -> List[str]:
        
        def bk(ptr):
            nonlocal s
            
            if ptr>=len(s):
                ans.append(s[:])
                return
            bk(ptr+1)
            if 96<ord(s[ptr])<123:
                olds=s
                ch=chr(ord(s[ptr])-32)
                s=s[:ptr]+ch+s[ptr+1:]
                bk(ptr+1)
                s=olds

        s=s.lower()
        ans=[]
        bk(0)
        return ans