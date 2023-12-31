class Solution:
    def maximumLength(self, s: str) -> int:
        m = [defaultdict(int) for _ in range(26)]
        l = 0
        r = 0
        n = len(s)
        ans = -1
        while r < n:
            while r < n and s[l] == s[r]:
                r += 1
            cur = r-l
            for i in range(1, cur+1):
                m[ord(s[l])-97][i] += cur - i + 1
            l = r
        
        for i in range(26):
            for k,v in m[i].items():
                if v>2:
                    ans = max(ans, k)
        
        return ans







# class Solution:
#     def maximumLength(self, s: str) -> int:
#         m = [defaultdict(int) for _ in range(26)]  # Use list comprehension to create defaultdicts
#         l = 0
#         r = 0
#         n = len(s)
#         ans = -1
#         while r < n:
#             while r < n and s[l] == s[r]:
#                 r += 1
#             m[ord(s[l]) - ord('a')][r - l] += 1
#             l = r 

# #         for i in range(26):
# #             print(list(m[i].items()))
#         for i in range(26):
#             for l,x in list(m[i].items()):
#                 if x>2:
#                     ans = max(ans, l)
#                 elif x==2 and m[i][l-1]>=1:
#                     ans = max(ans, l-1)
#                 elif x == 1:
#                     if m[i][l-1]>=1:
#                         ans = max(ans, l-1)
#                     elif l>2:
#                         ans = max(ans, l-2)
#             # print(c, l, x)
        
#         return ans



