class Solution {
    public int minGroups(int[][] intv) {
        int n = intv.length;
        Arrays.sort(intv, (a, b) -> a[0]==b[0] ? b[1]-a[1] : a[0]-b[0]);
        int st = intv[0][0];
        int end = intv[0][1];
        int ans = 0;
        boolean[] added = new boolean[n];
        // for(int[] x: intv) System.out.println(Arrays.toString(x));
        for(int i=0; i<n; ++i){
            ans += solve(i, intv, added) ? 1 : 0;
            // System.out.println(Arrays.toString(added));
        }
        return ans;
    }
    
    boolean solve(int i, int[][] intv, boolean[] added){
        if(i==intv.length || added[i]) return false;
        added[i] = true;
        
        int nx = bs(intv, i+1, intv[i][1]);
        while(nx<intv.length && added[nx]) ++nx;
        if(nx != intv.length) solve(nx, intv, added);
        
        return true;
    }
    
    int bs(int[][] nums, int i, int trgt){
        int j = nums.length-1;
        while(i<=j){
            int mid = i + (j-i)/2;
            if(nums[mid][0] > trgt) j = mid-1;
            else i = mid+1;
        }
        return i;
    }
}