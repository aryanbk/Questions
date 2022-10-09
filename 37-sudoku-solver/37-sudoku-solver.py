class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        
        def safe(i, j, n):
            rf, cf = i//3, j//3
            for a in range(9):
                if board[a][j]==n or board[i][a]==n or board[rf*3+a//3][cf*3+a%3]==n:
                    return False
            return True
        
        def bk(row, col):
            nonlocal stop
            
            if not stop:
                if row>=9:
                    stop=True
                    return
                if col>=9:
                    bk(row+1, 0)
                    return
                if board[row][col]==".":
                    for val in range(1, 10):
                        if safe(row, col, str(val)):
                            board[row][col]=str(val)
                            bk(row,col+1)
                            if not stop:
                                board[row][col]="."
                else:
                    bk(row, col+1)
        
        stop=False
        bk(0, 0)
                            
                    
        
        