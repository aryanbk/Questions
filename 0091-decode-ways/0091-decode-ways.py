class Solution:
    def numDecodings(self, s: str) -> int:
        def dfs(i):
            if i in memo:
                return memo[i]
            if s[i]=='0':
                return 0
            res = dfs(i+1)
            if i+1<len(s) and int(s[i:i+2])<27:
                res += dfs(i+2)
            memo[i] = res
            return memo[i]
        memo = {len(s):1}
        dfs(0)
        return memo[0] if 0 in memo else 0


# class Solution:
#     def numDecodings(self, s: str) -> int:
#         def solve(ptr):
#             if ptr>=len(s)-1: return 1
#             if mp[ptr]!=0: return mp[ptr]

#             num = (ord(s[ptr])-48)*10 + ord(s[ptr+1])-48
            
#             res=0
#             if num<10 or (num>26 and num%10==0):
#                 mp[ptr]=0
#                 mp[0]=0
#                 return mp[ptr]
#             if num%10!=0: res+=solve(ptr+1)
#             if num<=26: res+=solve(ptr+2)
            
#             mp[ptr]=res
#             return mp[ptr]
            

#         if s[0]=='0': return 0
#         mp=[0]*len(s)
#         solve(0)
#         return mp[0]