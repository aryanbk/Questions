class Solution {
    public int minimizedMaximum(int n, int[] quant) {
        int lo=1;
        int hi=0;
        int res=0;
        
        for(int q: quant) hi = Math.max(hi, q);
        
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            
            if(valid(quant, n, mid)){
                res = mid;
                hi = mid-1;
            }else
                lo = mid+1;
        }
        
        return res;
    }
    private boolean valid(int[] quant, int n, double maxi){
        for(int q: quant) n -= Math.ceil(q/maxi);
        return n>=0;
    }
}