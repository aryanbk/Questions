class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int total = m*n;
        List<Integer> ans = new ArrayList<>();
        
        int up = 0;
        int down = m-1;
        int left = 0;
        int right = n-1;
        
        
        while(ans.size() < total){
            for(int i=left; i<=right && ans.size()<total; ++i)
                ans.add(mat[up][i]);
            ++up;
            
            for(int i=up; i<=down && ans.size()<total; ++i)
                ans.add(mat[i][right]);
            --right;
            
            for(int i=right; i>=left && ans.size()<total; --i)
                ans.add(mat[down][i]);
            --down;
            
            for(int i=down; i>=up && ans.size()<total; --i)
                ans.add(mat[i][left]);
            ++left;
        }
        
        return ans;
    }
}



// class Solution {
//     int m;
//     int n;
//     List<Integer> ans;
//     public List<Integer> spiralOrder(int[][] mat) {
//         m = mat.length;
//         n = mat[0].length;
//         ans = new ArrayList<>();
//         solve(0, mat);
//         return ans;
//     }
    
//     void solve(int i, int[][] mat){
//         if(i >= (n+1)/2 || i >= (m+1)/2) return;
        
//         int st = i;
//         int end = n-i;
//         for(int x=st; x<end; ++x)
//             ans.add(mat[i][x]);
        
//         st = i+1;
//         end = m-i;
//         for(int x=st; x<end; ++x)
//             ans.add(mat[x][n-i-1]);
        
//         if(i < n/2 && i < m/2){
//             st = n-i-2;
//             end = i-1;
//             for(int x=st; x>end; --x)
//                 ans.add(mat[m-i-1][x]);
        
        
//             st = m-i-2;
//             end = i;
//             for(int x=st; x>end; --x)
//                 ans.add(mat[x][i]);
//         }
//             solve(i+1, mat);
//     }
// }