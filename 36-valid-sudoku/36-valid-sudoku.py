class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        for i in range(9):
            for j in range(9):
                if board[i][j]!=".":
                    n, rf, cf = board[i][j], (i//3)*3, (j//3)*3
                    board[i][j]="."
                    for a in range(9):
                        if board[a][j]==n or board[i][a]==n or board[rf+a//3][cf+a%3]==n:
                            return False
                    board[i][j]=n
                    
        return True