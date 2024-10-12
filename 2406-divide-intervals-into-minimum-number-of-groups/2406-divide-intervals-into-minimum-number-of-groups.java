class Solution {
    int n;
    public int minGroups(int[][] intv) {
        n = intv.length;
        int ans = 0;
        
        Arrays.sort(intv, (a, b) -> a[0]==b[0] ? b[1]-a[1] : a[0]-b[0]); // OR
        // Arrays.sort(intv, (a, b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]); 
        boolean[] added = new boolean[n];
        
        for(int i=0; i<n; ++i)
            ans += solve(i, intv, added) ? 1 : 0;
        
        return ans;
    }
    
    boolean solve(int i, int[][] intv, boolean[] added){
        if(i==n || added[i]) return false;
        added[i] = true;
        
        int nx = bs(intv, i+1, intv[i][1]);
        while(nx<n && added[nx]) ++nx;
        
        if(nx != n) solve(nx, intv, added);
        return true;
    }
    
    int bs(int[][] nums, int i, int trgt){
        int j = n-1;
        while(i<=j){
            int mid = i + (j-i)/2;
            if(nums[mid][0] > trgt) j = mid-1;
            else i = mid+1;
        }
        return i;
    }
}