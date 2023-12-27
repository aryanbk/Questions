class Solution:
    def minCost(self, colors: str, neededTime: List[int]) -> int:
        i=0
        ans=0
        while i<len(colors):
            j=i+1
            maxi, total = neededTime[i], neededTime[i]
            while j<len(colors) and colors[i]==colors[j]:
                maxi=max(maxi, neededTime[j])
                total += neededTime[j]
                j+=1
            if j!=i+1:
                ans += total-maxi
            i = j
        return ans