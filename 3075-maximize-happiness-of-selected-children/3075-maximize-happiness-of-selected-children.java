class Solution {
    public long maximumHappinessSum(int[] happi, int k) {
        Arrays.sort(happi);
        long ans = 0;
        for(int i=0; i<happi.length && k>0; ++i, --k)
            ans += Math.max(0, happi[happi.length-1-i]-i);
        return ans;
    }
}







// class Solution {
//     public long maximumHappinessSum(int[] happi, int k) {
//         PriorityQueue<Integer> pq = new PriorityQueue<>();
//         for(int i=0; i<happi.length; ++i){
//             pq.offer(happi[i]);
//             if(pq.size()>k) pq.poll();
//         }
        
//         long ans = 0;
//         while(k-->0)
//             ans += (long)Math.max(0, pq.poll()-k);
//         return ans;
//     }
// }