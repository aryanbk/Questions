class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        def move(i, j):
            nonlocal m,n
            if 0<=i<m and 0<=j<n:
                if memo[i][j] == -1:
                    memo[i][j] = move(i+1, j) + move(i, j+1)
                return memo[i][j]
            return 0
        
        memo = [[-1]*n for _ in range(m)]
        memo[-1][-1] = 1
        return move(0, 0)
