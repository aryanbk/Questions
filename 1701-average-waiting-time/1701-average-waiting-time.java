class Solution {
    public double averageWaitingTime(int[][] cust) {
        int n = cust.length;
        int t = 0;
        double sumt = 0;
        for(int[] c: cust){
            if(t<=c[0]){
                t = c[0] + c[1];
            }
            else{
                sumt += t-c[0];
                t += c[1];
            }
            sumt += c[1];
        }
        
        return sumt/n;
    }
}