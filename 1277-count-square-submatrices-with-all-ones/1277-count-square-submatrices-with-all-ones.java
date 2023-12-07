class Solution {
    public int countSquares(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int ans = 0;
        
        for(int i=0; i<n; ++i){ 
            for(int j=0; j<m; ++j){
                if(mat[i][j] == 1 && i>0 && j>0){
                    mat[i][j] = Math.min(Math.min(mat[i-1][j], mat[i][j-1]), mat[i-1][j-1]) + 1;
                }
                ans += mat[i][j];
            }
        }
        
        return ans;
    }
}


// // modified first attempt
// //
// class Solution {
//     public int countSquares(int[][] mat) {
//         int n = mat.length;
//         int m = mat[0].length;
// //         int[][][] map = new int[n][n][2];
        
// //         for(int i=0; i<n; ++i){
// //             for(int j=0; j<n; ++j){
// //                 if(mat[i][j] != 0){
// //                     map[i][j][0] = j>0 && map[i][j-1][0] > 0 ? map[i][j-1][0] + 1 : mat[i][j];
// //                     map[i][j][1] = i>0 && map[i-1][j][1] > 0 ? map[i-1][j][1] + 1 : mat[i][j];
// //                 }
// //             }
// //         }

//         int ans = 0;
//         for(int i=0; i<n; ++i){ 
//             for(int j=0; j<m; ++j){
//                 if(mat[i][j] == 1 && i>0 && j>0){
//                     // mat[i][j] = Math.min(mat[i-1][j-1] + 1, Math.min(map[i][j][0], map[i][j][1]));
//                     mat[i][j] = Math.min(Math.min(mat[i-1][j], mat[i][j-1]), mat[i-1][j-1]) + 1;
//                 }
//                 // ans = Math.max(ans, mat[i][j]*mat[i][j]);
//                 ans += mat[i][j];
//             }
//             // System.out.println(Arrays.toString(mat[i]));
//         }
        
//         return ans;
        
//     }
// }


// // first attempt
// // 
// class Solution {
//     public int countSquares(int[][] mat) {
//         int n = mat.length;
//         int m = mat[0].length;
//         int[][][] map = new int[n][m][2];
        
//         for(int i=0; i<n; ++i){
//             for(int j=0; j<m; ++j){
//                 if(mat[i][j] != 0){
//                     map[i][j][0] = j>0 && map[i][j-1][0] > 0 ? map[i][j-1][0] + 1 : mat[i][j];
//                     map[i][j][1] = i>0 && map[i-1][j][1] > 0 ? map[i-1][j][1] + 1 : mat[i][j];
//                 }
//             }
//         }

//         int ans = 0;
//         for(int i=0; i<n; ++i){ 
//             for(int j=0; j<m; ++j){
//                 if(mat[i][j] == 1 && i>0 && j>0){
//                     mat[i][j] = Math.min(mat[i-1][j-1] + 1, Math.min(map[i][j][0], map[i][j][1]));
//                 }
//                 // ans = Math.max(ans, mat[i][j]*mat[i][j]);
//                 ans += mat[i][j];
//             }
//             // System.out.println(Arrays.toString(mat[i]));
//         }
        
//         return ans;
        
//     }
// }