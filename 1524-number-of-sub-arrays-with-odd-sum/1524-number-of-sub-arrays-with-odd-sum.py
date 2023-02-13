# class Solution:
#     def numOfSubarrays(self, arr: List[int]) -> int:
#         count, sumt, ans = [1, 0], 0, 0
#         for i in arr:
#             sumt+=i
#             if sumt&1:
#                 ans += count[0]
#                 count[1]+=1
#             else:
#                 ans += count[1]
#                 count[0]+=1
#         return ans%(1000000007)

class Solution:
    def numOfSubarrays(self, arr: List[int]) -> int:
        def find(n, sumt):
            nonlocal ans
            if n==0:
                return [0, 1]
            odd, even = find(n-1, sumt-arr[n-1])
            if sumt&1:
                ans += even
                return [odd+1, even]
            else:
                ans += odd
                return [odd, even+1]
        
        ans = 0
        find(len(arr), sum(arr))
        return ans%(1000000007)