class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [[float('inf')]*(amount+1) for _ in range(len(coins)+1)]
        for l in range(len(dp)):
            for amt in range(amount+1):
                if amt==0: dp[l][amt] = 0
                elif l!=0:
                    if amt>=coins[l-1]: dp[l][amt] = min(dp[l-1][amt], 1 + dp[l][amt-coins[l-1]])
                    else: dp[l][amt] = dp[l-1][amt]
        return -1 if dp[-1][-1] == float('inf') else dp[-1][-1]