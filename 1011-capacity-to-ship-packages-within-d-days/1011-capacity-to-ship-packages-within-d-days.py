class Solution:
    def shipWithinDays(self, wt: List[int], days: int) -> int:
        
        def isValid(mxwt):
            day=1
            item=0
            while day<=days and item<len(wt):
                daywt=0
                while item<len(wt):
                    if daywt+wt[item]>mxwt:
                        break
                    if daywt+wt[item]<=mxwt:
                        daywt+=wt[item]
                        item+=1
                        
                day+=1
            return day-1<=days and item==len(wt)
        
        
        sm,mx=0,-1
        for i in wt:
            mx=max(mx, i)
            sm+=i
        lo,hi,res=mx,sm,sm
        while lo<=hi:
            mid=(lo+hi)//2
            if isValid(mid):
                res=mid
                hi=mid-1
            else:
                lo=mid+1
        return res