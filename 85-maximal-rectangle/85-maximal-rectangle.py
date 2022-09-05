class Solution:
    def maximalRectangle(self, mat: List[List[str]]) -> int:
        m,n = len(mat), len(mat[0])
        
        # maximum area of histerogram
        def mah(arr):
            # nearest smallest to the left
            def nsl():
                stk=[]
                res=[-1]*n
                for i in range(n):
                    while len(stk)>0 and arr[stk[-1]]>=arr[i]:
                        stk.pop()
                    if len(stk)!=0:
                        res[i]=stk[-1]
                    stk.append(i)
                return res
            
            # nearest smallest to the left
            def nsr():
                stk=[]
                res=[n]*n
                for i in range(n-1, -1, -1):
                    while len(stk)>0 and arr[stk[-1]]>=arr[i]:
                        stk.pop()
                    if len(stk)!=0:
                        res[i]=stk[-1]
                    stk.append(i)
                return res
            
            left=nsl()
            right=nsr()
            mx=0
            
            for i in range(n):
                mx=max(mx, (right[i]-left[i]-1)*arr[i])
            return mx
        
        
        histogram = [0]*n
        ans=0
        for i in range(m):
            for j in range(n):
                ele = int(mat[i][j])
                histogram[j] = 0 if ele==0 else histogram[j]+ele
            ans=max(ans, mah(histogram))
        return ans