class Solution:
    def findLength(self, nums1: List[int], nums2: List[int]) -> int:
        lth1, lth2, ans = len(nums1), len(nums2), 0
        prev = [0]*(lth2+1)
        
        for l1 in range(1, lth1+1):
            dp = [0]*(lth2+1)
            for l2 in range(1, lth2+1):
                if nums1[l1-1]==nums2[l2-1]:
                    dp[l2] = prev[l2-1] + 1
                    ans = max(ans, dp[l2])
            prev = dp
        return ans


# class Solution:
#     def findLength(self, nums1: List[int], nums2: List[int]) -> int:
#         lth1, lth2 = len(nums1), len(nums2)
#         dp = [[0]*(lth2+1) for _ in range(lth1+1)]
#         ans = 0
#         for l1 in range(1, len(dp)):
#             for l2 in range(1, len(dp[0])):
#                 if nums1[l1-1]==nums2[l2-1]:
#                     dp[l1][l2] = dp[l1-1][l2-1] + 1
#                     ans = max(ans, dp[l1][l2])
        
#         return ans