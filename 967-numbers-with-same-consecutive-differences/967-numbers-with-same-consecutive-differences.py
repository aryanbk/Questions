class Solution:
    def numsSameConsecDiff(self, n: int, k: int) -> List[int]:
        ans=[]
        def dfs(num, n):
            if n<=0:
                ans.append(num)
                return
            lastd=num%10
            for i in range(10):
                if abs(lastd-i)==k:
                    num = num*10 + i
                    dfs(num, n-1)
                    num=num//10
            return
        
        for i in range(1,10):
            dfs(i, n-1)
        return ans
        