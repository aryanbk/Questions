# class Solution:
#     def countOdds(self, low: int, high: int) -> int:
#         if low==high:
#             return low&1
#         ans = 0
#         if low&1:
#             ans+=1
#             low+=1
#         if high&1:
#             ans+=1
#             high-=1
#         if high-low>0:
#             ans += (high-low)//2
#         return ans

class Solution:
    def countOdds(self, low: int, high: int) -> int:
        return (high+1)//2 - low//2