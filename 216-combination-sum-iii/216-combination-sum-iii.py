class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        
        def bk(ptr, k, n, sub):
            if k==n==0:
                ans.append(sub.copy())
            elif not (k<=0 or n<=0 or ptr>9):
                for i in range(ptr, min(10, n+1)):
                    sub.append(i)
                    bk(i+1, k-1, n-i, sub)
                    sub.pop()
            
        
        ans=[]
        bk(1, k, n, [])
        return ans
        