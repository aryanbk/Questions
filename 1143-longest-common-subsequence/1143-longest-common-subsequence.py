class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        len1, len2 = len(text1), len(text2)
        dp = [[0]*(len2+1) for _ in range(len1+1)]
        
        for l1 in range(1, len(dp)):
            for l2 in range(1, len(dp[0])):
                dp[l1][l2] = 1+dp[l1-1][l2-1] if text1[l1-1]==text2[l2-1] else max(dp[l1-1][l2], dp[l1][l2-1])
        
        return dp[-1][-1]
        
        
        
        

# class Solution:
#     def longestCommonSubsequence(self, text1: str, text2: str) -> int:
#         def rec(l1, l2):
#             if l1<=0 or l2<=0: return 0
#             if dp[l1][l2]!=-1: return dp[l1][l2]
            
#             if text1[l1-1]==text2[l2-1]: dp[l1][l2] = rec(l1-1, l2-1)+1
#             else: dp[l1][l2] = max(rec(l1, l2-1), rec(l1-1, l2))
#             return dp[l1][l2]
        
#         dp = [[-1]*(len(text2)+1) for _ in range(len(text1)+1)]
#         return rec(len(text1), len(text2))



# class Solution:
#     def longestCommonSubsequence(self, text1: str, text2: str) -> int:
#         def rec(l1, l2):
#             if l1<=0 or l2<=0: return 0
#             if text1[l1-1]==text2[l2-1]:
#                 return rec(l1-1, l2-1)+1
#             return max(rec(l1, l2-1), rec(l1-1, l2))
        
#         return rec(len(text1), len(text2))