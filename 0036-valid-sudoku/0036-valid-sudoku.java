class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; ++i){
            for(int j=0; j<9; ++j){
                if(board[i][j] != '.'){
                    // to find top left of 3*3 cube
                    int rf = (i/3)*3;
                    int cf = (j/3)*3;
                    
                    char ch = board[i][j];
                    board[i][j] = '.';
                    
                    for(int x=0; x<9; ++x){
                        if(board[i][x]==ch || board[x][j]==ch || board[rf+x/3][cf+x%3]==ch)
                            return false;
                    }
                }
            }
        }
        return true;
    }
}