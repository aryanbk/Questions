class Solution {
    public int brokenCalc(int st, int trgt) {
        int ans = 0;
        while(st < trgt){
            if(trgt%2==1){
                ++trgt;
                ++ans;
            }
            trgt/=2;
            ++ans;
        }
        return ans + st-trgt;
    }
}






// class Solution {
//     public int brokenCalc(int st, int trgt) {
//         if(st >= trgt) return st-trgt;
//         return trgt%2==0 ? brokenCalc(st, trgt/2)+1 : brokenCalc(st, (trgt+1)/2)+2;
//     }
// }







// class Solution {
//     public int brokenCalc(int st, int trgt) {
//         if(st >= trgt) return trgt-st;
//         Queue<Integer> q = new LinkedList<>();
//         q.offer(st);
//         Set<Integer> vis = new HashSet<>();
        
//         for(int ans=0; !q.isEmpty(); ++ans){
//             int l = q.size();
//             for(int i=0; i<l; ++i){
//                 int cur = q.poll();
//                 if(cur==trgt) return ans;
//                 if(vis.contains(cur)) continue;
//                 vis.add(cur);
//                 if(cur*2 <= trgt+1) q.offer(cur*2);
//                 else{
                    
//                 }
//                 q.offer(cur-1);
//             }
//         }
//         return -1;
//     }
// }