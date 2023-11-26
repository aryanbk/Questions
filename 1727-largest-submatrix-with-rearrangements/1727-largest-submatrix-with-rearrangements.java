class Solution {
    public int largestSubmatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int ans = 0;

        for(int i=1; i<m; ++i){
            for(int j=0; j<n; ++j){
                // if curr==1 and prev is not 0 then
                // it's continous
                // we can add 1 in prev
                if(mat[i-1][j] != 0 && mat[i][j] != 0)
                    mat[i][j] = mat[i-1][j] + 1;
            }
        }
        
        for(int i=0; i<m; ++i){
            Arrays.sort(mat[i]);
            for(int j=0; j<n; ++j)
                ans = Math.max(ans, mat[i][j] * (n-j));
        }
        
        return ans;
    }
}