class Solution {
    int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public boolean exist(char[][] board, String word) {
        for(int i=0, m=board.length; i<m; i++)
            for(int j=0,n=board[0].length; j<n; j++)
                if(board[i][j]==word.charAt(0) && helper(board, word, i, j, 0))
                    return true;
        return false;
    }
    boolean helper(char[][] mat, String w, int i, int j, int p){
        if(p>=w.length()) return true;
        if(i<0 || i>=mat.length || j<0 || j>=mat[0].length || mat[i][j]!=w.charAt(p))
            return false;
        mat[i][j] -= 58;
        boolean ans = helper(mat, w, i+1, j, p+1) ||
            helper(mat, w, i-1, j, p+1) ||
            helper(mat, w, i, j+1, p+1) ||
            helper(mat, w, i, j-1, p+1);
        mat[i][j] += 58;
        return ans;
    }
}


// class Solution {
//     public boolean exist(char[][] board, String word) {
//         int m = board.length; 
//         int n = board[0].length;
//         for (int i = 0; i<m; i++) {
//             for (int j = 0; j<n; j++) {
//                 if (check(board, word, i, j, m, n, 0)) {
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
    
//     public boolean check(char[][] board, String word, int i, int j, int m, int n, int cur) {
//         if (cur>=word.length())
//             return true;
//         if (i<0 || j<0 || i>=m || j>=n || board[i][j]!=word.charAt(cur))
//             return false;
//         boolean exist = false;
//         if (board[i][j]==word.charAt(cur)) {
//             board[i][j] +=100;
//             exist = check(board, word, i+1, j, m, n, cur+1) ||
//                 check(board, word, i, j+1, m, n, cur+1) ||
//                 check(board, word, i-1, j, m, n, cur+1) ||
//                 check(board, word, i, j-1, m, n, cur+1);
//             board[i][j] -= 100;
//         }
//         return exist;
//     }
// }