class Solution:
    def distinctNames(self, ideas: List[str]) -> int:
        nums = [set() for i in range(26)]
        for w in ideas: nums[ord(w[0])-97].add(w[1:])
        ans = 0
        for i in range(26):
            for j in range(i+1, 26):
                ans += len(nums[i]-nums[j])*len(nums[j]-nums[i])*2
        return ans



# class Solution:
#     def distinctNames(self, ideas: List[str]) -> int:
#         nums = [set() for i in range(26)]
#         for w in ideas: nums[ord(w[0])-97].add(w[1:])
#         ans = 0
#         for i in range(26):
#             for j in range(i+1, 26):
#                 m, n = len(nums[i]-nums[j]), len(nums[j]-nums[i])
#                 ans += m*n*2
#         return ans
