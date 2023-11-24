class Solution:
    def maxCoins(self, piles: List[int]) -> int:
        piles.sort()
        i, j, ans = 0, len(piles)-2, 0
        while i<j:
            ans += piles[j]
            i+=1
            j-=2
        return ans