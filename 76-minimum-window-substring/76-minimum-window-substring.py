class Solution:
    def minWindow(self, s: str, t: str) -> str:
        fq=Counter(t)
        l=0
        anslo, anshi = 0, len(s)+1
        
        def valid():
            for i in fq.values():
                if i>0:
                    return False
            return True
        
        for r in range(len(s)):
            fq[s[r]] = fq.get(s[r], 0) -1
            
            while valid():
                if anshi-anslo > r-l+1:
                    anslo=l
                    anshi=r+1
                fq[s[l]]+=1
                l+=1
        
        return "" if (anslo==0 and anshi==len(s)+1) else s[anslo: anshi]
        


#####################################################################################


# class Solution:
#     def minWindow(self, s: str, t: str) -> str:
#         def valid():
#             for i in f:
#                 if f[i]<0: return False
#             return True
        
#         f={}
#         for i in t:
#             if i in f: f[i]-=1
#             else: f[i]=-1
        
#         i, j, ans= 0, 0, s+"0"
#         while j<len(s):
#             if s[j] in f: f[s[j]]+=1
#             else: f[s[j]]=1
            
#             while valid() and i<=j:
#                 if len(ans)>j-i+1: ans=s[i:j+1]
#                 f[s[i]]-=1
#                 i+=1
#             j+=1
        
#         return ans if ans!=s+"0" else ""