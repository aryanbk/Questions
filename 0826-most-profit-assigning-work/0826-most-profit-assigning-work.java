class Solution {
    public int maxProfitAssignment(int[] diff, int[] pr, int[] wrk) {
        int n = diff.length;
        
        int[][] pair = new int[n][2];
        for(int i=0; i<n; ++i) pair[i] = new int[]{diff[i], pr[i]};
        Arrays.sort(pair, (a, b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        
        int[] mxpr = new int[n+1];
        for(int i=1; i<=n; ++i) mxpr[i] = Math.max(mxpr[i-1], pair[i-1][1]);
        
        int ans = 0;
        for(int i=0; i<wrk.length; ++i){
            int idx = bs(pair, wrk[i]);
            ans += mxpr[idx+1];
        }
        
        return ans;
    }
    
    int bs(int[][] pair, int x){
        int lo = 0;
        int hi = pair.length-1;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(pair[mid][0] <= x) lo = mid + 1;
            else hi = mid -1;
        }
        return hi;
    }
}