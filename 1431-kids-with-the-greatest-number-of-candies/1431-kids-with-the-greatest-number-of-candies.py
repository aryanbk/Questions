class Solution:
    def kidsWithCandies(self, candies: List[int], extra: int) -> List[bool]:
        maxi=max(candies)
        ans=[False]*len(candies)
        for i in range(len(candies)):
            if candies[i]+extra >= maxi:
                ans[i]=True
        return ans