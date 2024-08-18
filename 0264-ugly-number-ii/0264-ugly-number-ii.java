class Solution {
    public int nthUglyNumber(int n) {
        var pq =  new PriorityQueue<Long>();
        var set = new HashSet<Long>();
        pq.offer(1L);
        set.add(1L);
        
        while(n>1 && !pq.isEmpty()){
            long cur = pq.poll();
            --n;
            
            if(!set.contains(cur*2)){
                pq.offer(cur*2);
                set.add(cur*2);
            }
            if(!set.contains(cur*3)){
                pq.offer(cur*3);
                set.add(cur*3);
            }
            if(!set.contains(cur*5)){
                pq.offer(cur*5);
                set.add(cur*5);
            }
            // pq.offer(cur*3);
            // pq.offer(cur*5);
            
        }
        
        return pq.poll().intValue();
    }
}