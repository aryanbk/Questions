class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if len(p)>len(s): return []
        mp=[0]*26
        for i in p: mp[ord(i)-97]+=1
        
        j, ms = 0, [0]*26
        while j<len(p):
            ms[ord(s[j])-97]+=1
            j+=1
        
        i, j, ans = 0, j-1, []
        while j<len(s):
            if mp==ms: ans.append(i)
            ms[ord(s[i])-97]-=1
            i+=1
            j+=1
            if j<len(s): ms[ord(s[j])-97]+=1
        
        return ans            