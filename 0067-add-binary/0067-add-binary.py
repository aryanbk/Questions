# class Solution:
#     def addBinary(self, a: str, b: str) -> str:
#         return bin(int(a, 2)+int(b, 2))[2:]

# class Solution:
#     def addBinary(self, a: str, b: str) -> str:
#         la, lb = len(a)-1, len(b)-1
#         if la<lb: return self.addBinary(b, a)
#         carry, ans = 0, ""
#         while lb>=0:
#             pos = int(a[la])+int(b[lb])+carry
#             ans = ans + str(pos%2)
#             carry = pos//2
#             la-=1
#             lb-=1
#         while la>=0:
#             pos = int(a[la])+carry
#             ans = ans + str(pos%2)
#             carry = pos//2
#             la-=1
#         if carry: ans = ans + str(carry)
#         return ans[::-1]

class Solution:
    def addBinary(self, a: str, b: str) -> str:
        def find(m , n , carry):
            if m==-1 and n==-1:
                if carry: ans.append(str(carry))
            elif n==-1:
                pos = int(a[m]) + carry
                ans.append(str(pos%2))
                find(m-1, n, pos//2)
            elif m==-1:
                pos = int(b[n]) + carry
                ans.append(str(pos%2))
                find(m, n-1, pos//2)
            else:
                pos = int(a[m]) + int(b[n]) + carry
                ans.append(str(pos%2))
                find(m-1, n-1, pos//2)
        
        ans = []
        find(len(a)-1, len(b)-1, 0)
        return "".join(ans[::-1])