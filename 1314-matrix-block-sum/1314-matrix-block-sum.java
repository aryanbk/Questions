class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                if(i>0)
                    mat[i][j] += mat[i-1][j];
                if(j>0)
                    mat[i][j] += mat[i][j-1];
                if(i>0 && j>0)
                    mat[i][j] -= mat[i-1][j-1];
            }
        }
        int[][] matrix = new int[m][n];
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                matrix[i][j] = mat[Math.min(i+k, m-1)][Math.min(j+k, n-1)];
                if(i-k-1>=0)
                    matrix[i][j] -= mat[i-k-1][Math.min(j+k, n-1)];
                if(j-k-1>=0)
                    matrix[i][j] -= mat[Math.min(i+k, m-1)][j-k-1];
                if(i-k-1>=0 && j-k-1>=0)
                    matrix[i][j] += mat[i-k-1][j-k-1];
            }
        }
        return matrix;
    }
}
