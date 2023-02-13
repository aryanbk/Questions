class Solution:
    def numOfSubarrays(self, arr: List[int]) -> int:
        count, sumt, ans = [1, 0], 0, 0
        for i in arr:
            sumt+=i
            if sumt&1:
                ans += count[0]
                count[1]+=1
            else:
                ans += count[1]
                count[0]+=1
        return ans%(1000000007)