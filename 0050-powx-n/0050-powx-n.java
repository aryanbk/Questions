class Solution {
    public double myPow(double x, int n) {
        double ans = 1.0;
        long m = n;
        if(m==0) return 1;
        if(m<0) m *= -1;
        
        while(m>0){
            if(m%2==1){
                ans *= x;
                --m;
            }else{
                x *= x;
                m/=2;
            }
        }
        
        return n>0 ? ans : 1/ans;
    }
}