class Solution {
    public int nthUglyNumber(int n) {
        var list = new ArrayList<Long>();
        list.add(1L);
        int two = 0;
        int three = 0;
        int five = 0;
        
        for(int i=1; i<n; ++i){
            long nextNum = Math.min(list.get(two)*2, Math.min(list.get(three)*3, list.get(five)*5));
            list.add(nextNum);
            if(nextNum == list.get(two)*2) ++two;
            if(nextNum == list.get(three)*3) ++three;
            if(nextNum == list.get(five)*5) ++five;
        }
        
        return list.get(list.size() - 1).intValue();
    }
}

// IMP
//
// class Solution {
//     public int nthUglyNumber(int n) {
//         var pq =  new PriorityQueue<Long>();
//         var set = new HashSet<Long>();
//         pq.offer(1L);
//         set.add(1L);
        
//         while(n>1 && !pq.isEmpty()){
//             long cur = pq.poll();
//             --n;
            
//             if(!set.contains(cur*2)){
//                 pq.offer(cur*2);
//                 set.add(cur*2);
//             }
//             if(!set.contains(cur*3)){
//                 pq.offer(cur*3);
//                 set.add(cur*3);
//             }
//             if(!set.contains(cur*5)){
//                 pq.offer(cur*5);
//                 set.add(cur*5);
//             }            
//         }
        
//         return pq.poll().intValue();
//     }
// }