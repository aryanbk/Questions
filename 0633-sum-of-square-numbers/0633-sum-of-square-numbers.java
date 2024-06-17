class Solution {
    public boolean judgeSquareSum(int c) {
        long i = 0;
        long j = (long) Math.sqrt(c);
        
        while(i<=j){
            long sumt = (i*i) + (j*j);
            if(sumt == (long) c) return true;
            else if(sumt > c) --j;
            else ++i;
        }
        return false;
    }
}