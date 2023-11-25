class Solution:
    def minimumCoins(self, prices: List[int]) -> int:
        @cache
        def find(i, last):
            if i == len(prices):
                return 0
            
            ans = math.inf
            if i <= last:
                ans = min(ans, find(i + 1, last))
                
            return min(prices[i] + find(i + 1, i + i + 1), ans)
        
        return find(0, -1)


# class Solution:
#     def minimumCoins(self, prices: List[int]) -> int:
#         def find(i, last):
#             if i==len(prices):
#                 return 0
#             if  (i, last) in memo:
#                 return memo[(i, last)]
#             ans = math.inf
#             if i<=last:
#                 ans = min(ans, find(i+1, last))
                
#             memo[(i, last)] = min(prices[i]+find(i+1, i+i+1), ans)
#             return memo[(i, last)]
        
#         memo={}
#         return find(0, -1)