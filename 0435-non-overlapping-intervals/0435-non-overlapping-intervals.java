class Solution {
    public int eraseOverlapIntervals(int[][] intvl) {
        Arrays.sort(intvl, (a,b)->Integer.compare(a[0], b[0]));
        int l=intvl.length, start=intvl[l-1][0], remove=0;
        
        for(int i=l-2; i>=0; --i){
            if(start >= intvl[i][1]) start = intvl[i][0];
            else remove++;
        }
        
        return remove;
    }
}