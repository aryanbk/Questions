class Solution:
    def reverse(self, x: int) -> int:
        if x<0:
            return self.reverse(-x)*-1
        ans = int(str(x)[::-1])
        maxi = (1<<31)-1
        return ans if (-maxi)-1<=ans<=maxi else 0
        