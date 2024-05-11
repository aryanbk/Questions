class Solution {
    public double mincostToHireWorkers(int[] qua, int[] wg, int k) {
        int n = qua.length;
        Double[][] rate = new Double[n][3];
        
        for(int i=0; i<n; ++i)
            rate[i] = new Double[]{(double)wg[i] / (double)qua[i], (double)qua[i], (double)wg[i]};
        Arrays.sort(rate, (a, b) -> a[0]-b[0] > 0 ? 1 : a[0]-b[0]< 0 ? -1 : 0);
        
        PriorityQueue<Double[]> pq = new PriorityQueue<>((a, b) -> (int)(b[1]-a[1]));
        Double totQ = 0.0;
        double ans = 1000000000;
        for(var r: rate){
            pq.offer(r);
            totQ += r[1];
            if(pq.size() > k){
                Double[] polled = pq.poll();
                totQ -= polled[1];
            }
            if(pq.size() == k){
                ans = Math.min(ans, totQ*r[0]);
            }
        }
        
        
        
        return ans;
    }
    
}











// class Solution {
//     public double mincostToHireWorkers(int[] qua, int[] wg, int k) {
//         int n = qua.length;
//         Double[][] rate = new Double[n][3];
        
//         for(int i=0; i<n; ++i)
//             rate[i] = new Double[]{(double)wg[i] / (double)qua[i], (double)qua[i], (double)wg[i]};
//         Arrays.sort(rate, (a, b) -> a[0]-b[0] > 0 ? 1 : a[0]-b[0]< 0 ? -1 : 0);
//         // for(var r: rate)
//         // System.out.println(Arrays.toString(r));
//         double ans = 1000000000;
//         for(int i=0; i<n+1-k; ++i){
//             int j = i+k-1;
//             double cur = 0;
//             double r = rate[j][0];
//             for(; j>=i; --j){
//                 cur += rate[j][2] + ((r-rate[j][0]) * rate[j][1]);
//                 // System.out.println(i+" "+j+" "+cur+" "+((r-rate[j][0]) * rate[j][1]));
//             }
//             // System.out.println(i+" "+j+" "+cur+" ****");
//             ans = Math.min(ans, cur);
//         }
        
//         return ans;
//     }
    
// }






// class Solution {
//     Map<Grp, Double> map;
//     public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
//         map = new HashMap<>();
//         return solve(0, 0, 0);
//     }
//     Double solve(int i, int qlt, int wge){
        
//     }
// }

// class Grp{
//     int i;
//     int qlt;
//     int wge;
//     public Grp(int ii, int qq, int ww){
//         i = ii;
//         qlt = qq;
//         wge = ww;
//     }
    
//     @Override
//     public int hashCode(){
//         return Objects.hash(i, qlt, wge);
//     }
    
//     @Override
//     public boolean equals(Object otr){
//         if (this == obj)
//             return true;
//         if (obj == null || getClass() != obj.getClass()) 
//             return false;
//         return i==otr.i && qlt==otr.qlt && wge==otr.wge;
//     }
// }