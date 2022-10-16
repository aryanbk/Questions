class Solution:
    def sumOfNumberAndReverse(self, num: int) -> bool:
        lo=0
        while lo<=num//2:
            if lo==int(str(num-lo)[::-1]):
                return True
            lo+=1
        return False