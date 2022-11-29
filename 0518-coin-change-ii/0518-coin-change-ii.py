class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [[0]*(len(coins)+1) for _ in range(amount+1)]
        for t in range(amount+1):
            for l in range(len(coins)+1):
                if t==0: dp[t][l] = 1
                elif l==0: dp[t][l] = 0
                else:
                    dp[t][l] = dp[t][l-1]
                    if t>=coins[l-1]: dp[t][l] += dp[t-coins[l-1]][l]
        return dp[-1][-1]



# class Solution:
#     def change(self, amount: int, coins: List[int]) -> int:
#         dp = [[0]*(len(coins)+1) for _ in range(amount+1)]
#         for t in range(amount+1):
#             for l in range(len(coins)+1):
#                 if t==0: dp[t][l] = 1
#                 elif l==0: dp[t][l] = 0
#                 else:
#                     if t>=coins[l-1]: dp[t][l] = dp[t][l-1] + dp[t-coins[l-1]][l]
#                     else: dp[t][l] = dp[t][l-1]
#         return dp[-1][-1]