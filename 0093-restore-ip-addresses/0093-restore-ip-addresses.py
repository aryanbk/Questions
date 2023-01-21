class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        def find(ptr, curr, dot):
            if dot==0 and ptr<len(s) and 0<=int(s[ptr:])<256 and not (len(s)-ptr>1 and s[ptr]=='0'):
                ans.append(curr+s[ptr:])
                
            if dot>0:
                for i in range(1,4):
                    if i!=1 and s[ptr]=='0':
                        continue
                    if dot>0 and 0<=int(s[ptr:ptr+i])<256 and ptr+i<len(s):
                        temp = curr[:] + s[ptr:ptr+i]+"."
                        find(ptr+i, temp, dot-1)
        
        ans=[]
        find(0, "", 3)
        return ans




# class Solution:
#     def restoreIpAddresses(self, s: str) -> List[str]:
#         def find(ptr, curr, dot):
#             if ptr<len(s):
#                 if dot==0 and ptr<len(s) and 0<=int(s[ptr:])<256:
#                     if not (len(s)-ptr>1 and s[ptr]=='0'):
#                         ans.append(curr+s[ptr:])
#                     return
#                 if dot>0 and 0<=int(s[ptr:ptr+1])<256:
#                     temp = curr[:] + s[ptr:ptr+1]+"."
#                     find(ptr+1, temp, dot-1)
#                 if dot>0 and 0<=int(s[ptr:ptr+2])<256 and s[ptr]!='0':
#                     temp = curr[:] + s[ptr:ptr+2]+"."
#                     find(ptr+2, temp, dot-1)
#                 if dot>0 and 0<=int(s[ptr:ptr+3])<256 and s[ptr]!='0':
#                     temp = curr[:] + s[ptr:ptr+3]+"."
#                     find(ptr+3, temp, dot-1)
#             return
        
#         ans=[]
#         find(0, "", 3)
#         return ans