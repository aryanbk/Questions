class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] prexor = new int[n+1];
        for(int i=1; i<n+1; ++i) prexor[i] = arr[i-1]^prexor[i-1];
        
        int[] ans = new int[queries.length];
        for(int i=0; i<queries.length; ++i){
            int[] q = queries[i];
            ans[i] = prexor[q[1]+1] ^ prexor[q[0]];
        }
        
        return ans;
    }
}