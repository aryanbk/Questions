class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();
        for(var n: nums)
            map.put(n, map.getOrDefault(n, 0) + 1);
        
        var pq = new PriorityQueue<int[]>(Comparator.comparingInt(a -> a[0]));
        for(var key : map.keySet()){
            pq.offer(new int[]{map.get(key), key});
            if(pq.size() > k)
                pq.poll();
        }
        
        int[] ans = new int[k];
        int ptr = 0;
        
        for(var x: pq)
            ans[ptr++] = x[1];
        
        return ans;
    }
}