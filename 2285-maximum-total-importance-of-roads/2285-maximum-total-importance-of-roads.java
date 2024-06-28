class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] indg = new int[n];
        for(int[] r: roads){
            ++indg[r[0]];
            ++indg[r[1]];
        }
        Arrays.sort(indg);
        long ans = 0;
        for(int i=0; i<n; ++i)
            ans += ((long)indg[i])*((long)(i+1));
        return ans;
    }
}