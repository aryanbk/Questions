class Solution:
    def wordPattern(self, pattern: str, str: str) -> bool:
        d, s = {}, set()
        s2=str.split()
        if len(s2)!=len(pattern): return False
        l = len(s2)
        for i in range(l):
            if pattern[i] in d:
                if d[pattern[i]]!=s2[i]: return False
            else:
                if s2[i] in s: return False
                d[pattern[i]]=s2[i]
            s.add(s2[i])
        return True
        