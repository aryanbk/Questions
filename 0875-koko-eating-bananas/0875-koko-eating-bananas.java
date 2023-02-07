class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=0, res=0, r=0;
        for(int p: piles) r=Math.max(r, p);
        while(l<=r){
            int mid = l+(r-l)/2;
            if(valid(mid, h, piles)){
                res=mid;
                r=mid-1;
            }
            else l=mid+1;
        }
        return res;
    }
    private boolean valid(int mid, int h, int[] piles){
        long time=0;
        for(int p: piles) time += Math.ceil((double)p / (double)mid);
        return time<=h;
    }
}