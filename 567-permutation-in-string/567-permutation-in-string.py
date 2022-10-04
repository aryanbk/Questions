class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        fq=Counter(s1)
        l=0
        
        for r in range(len(s2)):
            fq[s2[r]]=fq.get(s2[r], 0) - 1
            
            while r-l+1>len(s1):
                fq[s2[l]]+=1
                l+=1
            
            # valid() function
            res=True
            for v in fq.values():
                if v!=0:
                    res=False
                    break
            if res:
                return res
            
        return False
        