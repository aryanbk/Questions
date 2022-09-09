class Solution:
    def clumsy(self, n: int) -> int:
        if n<3:
            return n
        ans=(n*(n-1)//(n-2))+(n-3)
        n-=4
        while n>0:
            if n<3:
                return ans - n
            ans = ans - (n*(n-1)//(n-2))+(n-3)
            n=n-4
        return ans