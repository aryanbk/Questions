// // we can also use char as number if its '0' make it (char)0
// // we can also use char as number if its '10' make it (char)10
// // to get O(1) space complexity



// // O(m*n)
//
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] mat = new int[m][n];
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                mat[i][j] = matrix[i][j] == '1' ? 1 : 0;
            }
        }   
        
        int ans = 0;
        
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                if(i>0 && j>0 && mat[i][j]==1){
                    int up = mat[i-1][j];
                    int left = mat[i][j-1];
                    int diag = mat[i-1][j-1];
                    mat[i][j] = Math.min(up, Math.min(left, diag)) + 1;
                }
                ans = Math.max(ans, mat[i][j]);
            }
        }
        
        return ans*ans;
    }
}


// // wont run if when the squre is more than 9
// // char wont store '10'

// class Solution {
//     public int maximalSquare(char[][] mat) {
        
//         int m = mat.length;
//         int n = mat[0].length;
//         // int m = matrix.length;
//         // int n = matrix[0].length;
        
        
        
// //         int[][] mat = new int[m][n];
// //         for(int i=0; i<m; ++i){
// //             for(int j=0; j<n; ++j){
// //                 mat[i][j] = matrix[i][j] == '1' ? 1 : 0;
// //             }
// //         }
        
//         int ans = 0;

//         for(int i=0; i<m; ++i){
//             for(int j=0; j<n; ++j){
//                 if(i>0 && j>0 && mat[i][j]=='1'){
//                     int up = mat[i-1][j] - '0';
//                     int left = mat[i][j-1] - '0';
//                     int diag = mat[i-1][j-1] - '0';
//                     mat[i][j] = (char)(Math.min(up, Math.min(left, diag)) + '1');
//                 }
//                 ans = Math.max(ans, mat[i][j]-'0');
//             }
//         }
//         for(char[] c: mat){
//             System.out.println(Arrays.toString(c));
//         }
//         return ans*ans;
//     }
// }