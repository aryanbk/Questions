class Solution {
    public int maxProfitAssignment(int[] diff, int[] pft, int[] wrkr) {
        int n = diff.length;
        int[][] cmb = new int[n][2];
        
        for(int i=0; i<n; ++i) cmb[i] = new int[]{pft[i], diff[i]};
        
        Arrays.sort(cmb, (a, b)-> b[0]-a[0]);
        Arrays.sort(wrkr);
        int ans = 0;
        
        for(int i=0, j=wrkr.length-1; i<n && j>=0; ++i){
            while(j>=0 && wrkr[j] >= cmb[i][1]){
                ans += cmb[i][0];
                --j;
            }
        }
        return ans;
    }
}