class Solution {
    int m;
    int n;
    public int[][] imageSmoother(int[][] img) {
        m = img.length;
        n = img[0].length;
        
        int[][] ans = new int[m][n];
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                ans[i][j] = getAvg(i, j, img);
            }
        }
        return ans;
    }
    
    int getAvg(int i, int j, int[][] img){
        int sumt = 0;
        int cnt = 0;
        for(int x=Math.max(i-1, 0); x<=Math.min(i+1, m-1); ++x){
            for(int y = Math.max(j-1, 0); y<=Math.min(j+1, n-1); ++y){
                sumt += img[x][y];
                ++cnt;
            }
        }
        return (int) Math.floor(sumt/cnt);
    }
}