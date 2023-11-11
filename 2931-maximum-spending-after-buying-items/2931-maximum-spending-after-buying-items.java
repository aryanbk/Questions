class Solution {
    public long maxSpending(int[][] values) {
        int n = values.length, m = values[0].length;
        
        int[] ptr = new int[n];
        Arrays.fill(ptr, m-1);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        for(int i=0; i<n; ++i)
            pq.offer(new int[]{values[i][m-1], i});
        
        int d = 1;
        long ans = 0;
        
        while(!pq.isEmpty()){
            int price = pq.peek()[0];
            int shop = pq.peek()[1];
            pq.poll();
            
            ans += (long)price*d++;
            // ans += price*d++;    caused wrong answer
            
            if(ptr[shop] > 0){
                ptr[shop]--;
                pq.offer(new int[]{values[shop][ptr[shop]], shop});
                
            }
        }
        return ans;
    }
}