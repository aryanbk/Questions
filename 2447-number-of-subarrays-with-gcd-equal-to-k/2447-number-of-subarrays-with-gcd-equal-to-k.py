class Solution:
    def subarrayGCD(self, nums: List[int], k: int) -> int:
        l, ans = len(nums), 0
        for i in range(l):
            gcd=0
            for j in range(i, l):
                gcd = math.gcd(gcd, nums[j])
                if gcd<k:
                    break
                elif gcd==k:
                    ans+=1
        return ans
        