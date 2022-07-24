class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i=0, j=matrix[0].length-1;
        while(i<matrix.length && j>=0 && target!=matrix[i][j]){
            if(target>matrix[i][j]) i++;
            else j--;
        }
        return (i>=matrix.length || j<0) ? false : true;
    }
}