class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int n = arrays.size();
        int mn = Integer.MAX_VALUE;
        int mn2 = Integer.MAX_VALUE;
        int mnIdx = -1;
        int mx = Integer.MIN_VALUE;
        int mx2 = Integer.MIN_VALUE;
        int mxIdx = -1;
        
        for(int i=0; i<n; ++i){
            var a = arrays.get(i);
            
            int curMn = a.get(0);
            int curMx = a.get(a.size()-1);
            if(curMn<=mn){
                mn2 = mn;
                mn = curMn;
                mnIdx = i;
            }
            else mn2 = Math.min(mn2, curMn);
            
            if(curMx >= mx){
                mx2 = mx;
                mx = curMx;
                mxIdx = i;
            }
            else mx2 = Math.max(mx2, curMx);
        }
        
        
        if(mnIdx == mxIdx) return Math.max(mx - mn2, mx2 - mn);
        return mx - mn;
    }
}