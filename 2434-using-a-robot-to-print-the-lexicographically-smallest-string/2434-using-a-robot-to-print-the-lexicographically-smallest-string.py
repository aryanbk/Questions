class Solution:
    def robotWithString(self, s: str) -> str:
        
        
        def isSmall():
            ptr = 97
            while ptr<ord(t[-1]):
                if c[chr(ptr)]>0:
                    return True
                ptr+=1
            return False
        
        
        
        c = Counter(s)
        i=1
        t = [s[0]]
        c[s[0]]-=1
        ans=""
        
        while i<len(s):
            if not t or isSmall():
                t.append(s[i])
                c[s[i]]-=1
                i+=1
            else:
                ans += t.pop()
        
        while t:
            ans += t.pop()
        
        return ans