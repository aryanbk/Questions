class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        def add(n):
            if n>numRows:
                return ans
            sub = [1]*n
            for i in range(1, n-1): sub[i] = ans[-1][i]+ans[-1][i-1]
            ans.append(sub)
            return add(n+1)
        
        ans =[[1]]
        return add(2)
