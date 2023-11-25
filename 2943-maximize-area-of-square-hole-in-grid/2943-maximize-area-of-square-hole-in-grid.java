class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int ansRoot = Math.min(solve(hBars, n), solve(vBars, m));
        return (int)Math.pow(ansRoot, 2);
    }
    private int solve(int[] bar, int n){
        int mx = 1;
        int curr = 1;
        
        for(int i=1; i<bar.length; ++i){
            if(bar[i]-bar[i-1] == 1){
                curr++;
                mx = Math.max(mx, curr);
            }
            else{
                curr = 1;
            }
        }
        
        return mx+1;
    }
}