class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->
        Double.compare((double)b[0]/(double)b[1], (double)a[0]/(double)a[1]));
        // reverse double compare
        
        for(int i=0; i<n; ++i){
            for(int j=i+1; j<n; ++j){
                pq.offer(new int[]{arr[i], arr[j]});
                while(pq.size() > k) pq.poll();
            }
        }
        return pq.poll();
        
    }
}





// class Solution {
//     public int[] kthSmallestPrimeFraction(int[] arr, int k) {
//         int n = arr.length;
//         PriorityQueue<Curr> pq = new PriorityQueue<>();
        
//         for(int i=0; i<n; ++i){
//             for(int j=i+1; j<n; ++j){
//                 Curr cur = new Curr(arr[i], arr[j]);
//                 pq.offer(cur);
//                 while(pq.size() > k) pq.poll();
//             }
//         }
//         // System.out.println(pq);
//         Curr ans = pq.poll();
//         return new int[]{ans.i, ans.j};
        
//     }
// }


// class Curr implements Comparable<Curr>{
//     int i;
//     int j;
//     public Curr(int ii, int jj){
//         i = ii;
//         j = jj;
//     }
    
//     @Override
//     public int compareTo(Curr two){
//         double fir = (double)this.i / (double) this.j;
//         double sec = (double)two.i / (double) two.j;
        
//         return Double.compare(sec, fir);
//     }
    
//     @Override
//     public String toString(){
//         return this.i+" "+this.j;
//     }
// }