class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        
        def bk(i, j, ptr):
            if ptr>=len(word):
                return True
            if i<0 or j<0 or i>=len(board) or j>=len(board[0]) or board[i][j]!=word[ptr]:
                return False
            board[i][j]='#'
            res=bk(i+1, j, ptr+1) or bk(i, j+1, ptr+1) or bk(i-1, j, ptr+1) or bk(i, j-1, ptr+1)
            board[i][j]=word[ptr]
            return res
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j]==word[0] and bk(i, j, 0):
                    return True
        return False
        