class Solution:
    def findMinFibonacciNumbers(self, k: int) -> int:
        fib=[1, 1]
        while fib[-1]<k:
            fib.append(fib[-1]+fib[-2])
        i, ans = len(fib)-1, 0
        while k!=0 and i>=0:
            if fib[i]<=k:
                ans+=1
                k-=fib[i]
            else:
                i-=1
        return ans