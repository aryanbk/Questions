class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] prexor = new int[n+1];
        prexor[0] = 0;
        for(int i=0; i<n; ++i) prexor[i+1] = arr[i]^prexor[i];
        int[] ans = new int[queries.length];
        for(int i=0; i<queries.length; ++i){
            int[] q = queries[i];
            ans[i] = prexor[q[1]+1] ^ prexor[q[0]];
        }
        return ans;
    }
}