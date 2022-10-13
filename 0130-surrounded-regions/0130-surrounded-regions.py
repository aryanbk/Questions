class Solution:
    def solve(self, board: List[List[str]]) -> None:
        m,n,q = len(board), len(board[0]), []

        for i in range(m):
            for j in range(n):
                if (i==0 or j==0 or i==m-1 or j==n-1) and board[i][j]=="O":
                    q.append([i, j])
                    
        drctn=[[1,0], [0,1], [0, -1], [-1, 0]]
        while q:
            i, j = q.pop(0)
            board[i][j]="#"
            for d in drctn:
                if not (i+d[0]<0 or j+d[1]<0 or i+d[0]>=m or j+d[1]>=n or board[i+d[0]][j+d[1]]!="O"):
                    q.append([i+d[0], j+d[1]])
        
        for i in range(m):
            for j in range(n):
                board[i][j]="O" if board[i][j]=="#" else "X"
        
