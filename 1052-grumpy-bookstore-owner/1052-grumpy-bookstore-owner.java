class Solution {
    public int maxSatisfied(int[] cst, int[] gmp, int mnt) {
        int n = cst.length;
        int sumt = 0;
        int sumtGmp = 0;
        
        for(int i=0; i<n; ++i){
            sumt += cst[i];
            cst[i] = cst[i]*gmp[i];
            sumtGmp += cst[i];
        }
        
        int curSumt = 0;
        int mx = 0;
        
        for(int l=0, r=0; r<n; ++r){
            curSumt += cst[r];
            if(r-l+1 == mnt){
                mx = Math.max(mx, curSumt);
                curSumt -= cst[l];
                ++l;
            }
        }
        
        return sumt - sumtGmp + mx;
    }
}