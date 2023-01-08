class Solution:
    def minimumLines(self, sp: List[List[int]]) -> int:
        sp.sort()
        if len(sp)==1: return 0
        ans=1
        for i in range(2, len(sp)):
            if (sp[i][1]-sp[i-1][1])*(sp[i-1][0]-sp[i-2][0]) != (sp[i-1][1]-sp[i-2][1])*(sp[i][0]-sp[i-1][0]): ans+=1
        return ans