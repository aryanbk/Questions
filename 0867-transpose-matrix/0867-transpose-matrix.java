class Solution {
    public int[][] transpose(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] mat2 = new int[n][m];
        for(int i=0; i<mat.length; ++i){
            for(int j=0; j<mat[0].length; ++j){
                mat2[j][i] = mat[i][j];
            }
        }
        return mat2;
    }
}