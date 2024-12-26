// TC O(m * n)
// SC O(1)
class Solution {
    int m;
    int n;
    int[][] dir = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1},
                              {1, -1}, {1, 0}, {1, 1}};
    
    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;
        
        count(board);
        change(board);
    }
    
    void count(int[][] b){
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                int nbrCount = 0;
                for(int x=0; x<8; ++x)
                    nbrCount += valid(b, i+dir[x][0], j+dir[x][1]);
                nbrCount *= 10;
                b[i][j] += nbrCount;
            }
        }
    }
    
    void change(int[][] b){
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                int nbrCount = b[i][j]/10;
                b[i][j]%=10;
                
                if(b[i][j]==1){
                    if(nbrCount <2 || nbrCount>3) b[i][j] = 0;
                }
                else{
                    if(nbrCount==3) b[i][j]=1;
                }
            }
        }
    }
    
    int valid(int[][] b, int i, int j){
        return i>=0 && j>=0 && i<m && j<n && b[i][j]%10==1 ? 1 : 0;
    }
    
}



// // TC O(m * n)
// // SC O(m * n)
// class Solution {
//     int m;
//     int n;
//     int[][] nbrCount;
//     int[][] dir = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1},
//                               {1, -1}, {1, 0}, {1, 1}};
    
//     public void gameOfLife(int[][] board) {
//         m = board.length;
//         n = board[0].length;
//         nbrCount = new int[m][n];
        
//         count(board);
//         change(board);
//     }
    
//     void count(int[][] b){
//         for(int i=0; i<m; ++i){
//             for(int j=0; j<n; ++j){
//                 for(int x=0; x<8; ++x)
//                     nbrCount[i][j] += valid(b, i+dir[x][0], j+dir[x][1]);
//             }
//         }
//     }
    
//     void change(int[][] b){
//         for(int i=0; i<m; ++i){
//             for(int j=0; j<n; ++j){
//                 if(b[i][j]==1){
//                     if(nbrCount[i][j] <2 || nbrCount[i][j]>3) b[i][j] = 0;
//                 }
//                 else{
//                     if(nbrCount[i][j]==3) b[i][j]=1;
//                 }
//             }
//         }
//     }
    
//     int valid(int[][] b, int i, int j){
//         return i>=0 && j>=0 && i<m && j<n && b[i][j]==1 ? 1 : 0;
//     }
    
// }