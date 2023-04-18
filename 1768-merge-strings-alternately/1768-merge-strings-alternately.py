class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        m, n  = len(word1), len(word2)
        ans = []
        i=0
        while i<max(m, n):
            if i<m:
                ans.append(word1[i])
            if i<n:
                ans.append(word2[i])
            i+=1
        
        return "".join(ans)
        