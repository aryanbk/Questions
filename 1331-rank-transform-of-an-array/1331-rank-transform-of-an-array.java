class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if(arr.length == 0) return new int[0];
        int[][] mat = new int[arr.length][2];
        for(int i=0; i<arr.length; ++i) mat[i] = new int[]{arr[i], i};
        Arrays.sort(mat, (a, b) -> a[0]-b[0]);
        int[] ans = new int[arr.length];
        int cur = mat[0][0];
        int rank = 1;
        // int[] ans = new int[arr.length];
        for(int i=0; i<mat.length; ++i){
            if(mat[i][0]==cur){
                ans[mat[i][1]] = rank;
            }
            else{
                ans[mat[i][1]] = ++rank;
                cur = mat[i][0];
            }
        }
        
        return ans;
    }
}