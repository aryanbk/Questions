class Solution:
    def solve(self, board: List[List[str]]) -> None:
        m,n = len(board), len(board[0])
        q=[]

        for i in range(m):
            for j in range(n):
                if (i==0 or j==0 or i==m-1 or j==n-1) and board[i][j]=="O":
                    q.append([i, j])
                    
        zero = [[0]*n for _ in range(m)]
        drctn=[[1,0], [0,1], [0, -1], [-1, 0]]
        while q:
            i, j = q.pop(0)
            zero[i][j]+=1
            for d in drctn:
                if not (i+d[0]<0 or j+d[1]<0 or i+d[0]>=m or j+d[1]>=n or zero[i+d[0]][j+d[1]]!=0 or board[i+d[0]][j+d[1]]=='X'):
                    q.append([i+d[0], j+d[1]])
        
        for i in range(m):
            for j in range(n):
                if zero[i][j]==0:
                    board[i][j]="X"
        
