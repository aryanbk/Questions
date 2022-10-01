class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        past, ans = set(), set()
        for i in range(0, len(s)-9):
            sttr=s[i: i+10]
            if sttr in past: ans.add(sttr)
            else: past.add(sttr)
        return ans



# this won't work....
    
# class Solution:
#     def findRepeatedDnaSequences(self, s: str) -> List[str]:
#         def addit(j, add):
#             num=0
#             if s[j]=="C": num=1
#             elif s[j]=='G': num=2
#             elif s[j]=='T': num=3
#             if add: slid[num]+=1
#             else: slid[num]-=1
        
#         mp={}
#         i, j, slid=0, 0, [0]*4
#         while j<len(s):
#             addit(j, True)
#             if j-i+1 == 10:
#                 if slid in mp: mp[slid]+=1
#                 else: mp[slid]=1
#                 addit(i, False)
#                 i+=1
#             j+=1
        
#         ans=[]
#         for i in mp:
#             if i>1: ans.append(i)
#         return ans
        