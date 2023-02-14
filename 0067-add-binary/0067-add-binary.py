# class Solution:
#     def addBinary(self, a: str, b: str) -> str:
#         return bin(int(a, 2)+int(b, 2))[2:]

class Solution:
    def addBinary(self, a: str, b: str) -> str:
        la, lb = len(a), len(b)
        if la<lb:
            return self.addBinary(b, a)
        la-=1
        lb-=1
        carry=0
        ans=""
        while lb>=0:
            pos = int(a[la])+int(b[lb])+carry
            ans = ans + str(pos%2)
            carry = pos//2
            la-=1
            lb-=1
        while la>=0:
            pos = int(a[la])+carry
            ans = ans + str(pos%2)
            carry = pos//2
            la-=1
        if carry: ans = ans + str(carry)
        return ans[::-1]