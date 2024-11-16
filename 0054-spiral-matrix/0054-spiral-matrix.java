class Solution {
    int m;
    int n;
    List<Integer> ans;
    public List<Integer> spiralOrder(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        ans = new ArrayList<>();
        solve(0, mat);
        return ans;
    }
    
    void solve(int i, int[][] mat){
        if(i >= (n+1)/2 || i >= (m+1)/2) return;
        
        int st = i;
        int end = n-i;
        for(int x=st; x<end; ++x)
            ans.add(mat[i][x]);
        
        st = i+1;
        end = m-i;
        for(int x=st; x<end; ++x)
            ans.add(mat[x][n-i-1]);
        
        if(i < n/2 && i < m/2){
            st = n-i-2;
            end = i-1;
            for(int x=st; x>end; --x)
                ans.add(mat[m-i-1][x]);
        
        
            st = m-i-2;
            end = i;
            for(int x=st; x>end; --x)
                ans.add(mat[x][i]);
        }
            solve(i+1, mat);
    }
}