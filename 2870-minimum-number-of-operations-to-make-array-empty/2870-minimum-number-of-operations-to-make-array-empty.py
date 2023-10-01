class Solution:
    def minOperations(self, nums: List[int]) -> int:
        c = Counter(nums)
        ans = 0
        for k,v in c.items():
            if v==1:
                return -1
            elif v%3==1 or v%3==2:
                ans += v//3 + 1
            elif v%3==0:
                ans += v//3
        return ans
                

        