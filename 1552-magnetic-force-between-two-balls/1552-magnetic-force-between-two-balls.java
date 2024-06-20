class Solution {
    public int maxDistance(int[] pos, int m) {
        Arrays.sort(pos);
        int lo = 1;
        int hi = pos[pos.length-1] - pos[0];
        int ans = -1;
        
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(valid(pos, m, mid)){
                ans = mid;
                lo = mid + 1;
            }
            else
                hi = mid - 1;
        }
        return ans;
    }
    
    boolean valid(int[] pos, int m, int d){
        int last = pos[0];
        for(int i=1; i<pos.length; ++i){
            if(pos[i]-last >= d){
                --m;
                last = pos[i];
            }
        }
        return m<=1;
    }
}