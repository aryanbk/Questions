class Solution:
    def trap(self, height: List[int]) -> int:
        l=len(height)
        def mxl():
            mx=0
            res=[0]*l
            for i in range(l):
                res[i]=mx
                mx=max(mx, height[i])
            return res
        
        def mxr():
            mx=0
            res=[0]*l
            for i in range(l-1, -1, -1):
                res[i]=mx
                mx=max(mx, height[i])
            return res
        
        left=mxl()
        rit=mxr()
        ans=0
        for i in range(l):
            waterAbove=min(left[i], rit[i])-height[i]
            ans += 0 if waterAbove<0 else waterAbove
        return ans