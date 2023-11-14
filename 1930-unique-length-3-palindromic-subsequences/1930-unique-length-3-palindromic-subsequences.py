class Solution:
    def countPalindromicSubsequence(self, s: str) -> int:
        ans = 0
        for c in range(97, 97+26):
            i, j = s.find(chr(c)), s.rfind(chr(c))
            if(i!=-1):
                ans += len(set(s[i+1:j]))
        return ans