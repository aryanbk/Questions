class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        l=0
        ans=0
        freq=set()
        for r in range(len(s)):
            while s[r] in freq:
                freq.remove(s[l])
                l+=1
            freq.add(s[r])
            ans=max(ans, r-l+1)
        return ans
        



# class Solution:
#     def lengthOfLongestSubstring(self, s: str) -> int:
#         i, j, ans, f= 0, 0, 0, {}
#         while j<len(s) and i<len(s):
#             if s[j] not in f or f[s[j]]==0:
#                 f[s[j]]=1
#                 j+=1
#                 ans=max(ans, j-i)
#             else : #if s[j] in f and f[s[j]]!=0
#                 f[s[i]]-=1
#                 i+=1
#         return ans