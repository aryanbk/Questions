class Solution {
    public int minFallingPathSum(int[][] mat) {
        int n = mat.length;
        
        for(int i=1; i<n; ++i){
            for(int j=0; j<n; ++j){
                int prev = mat[i-1][j];
                if(j>0) prev = Math.min(prev, mat[i-1][j-1]);
                if(j<n-1) prev = Math.min(prev, mat[i-1][j+1]);
                mat[i][j] += prev;
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i<n; ++i) ans = Math.min(ans, mat[n-1][i]);
        
        return ans;
    }
}