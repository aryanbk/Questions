class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        int n = nums.length;
        var map = new HashMap<Integer, Integer>();
        
        for(var x: nums)
            map.put(x, map.getOrDefault(x, 0) + 1);
        
        var bucket = new ArrayList[n+1];
        for(var key : map.keySet()){
            int freq = map.get(key);
            if(bucket[freq] == null)
                bucket[freq] = new ArrayList<>();
            bucket[freq].add(key);
        }
        
        int[] ans = new int[k];
        for(int i=n; i>0 && k>0; --i){
            for(int x=0; bucket[i] != null && x<bucket[i].size() && k>0; ++x, --k)
                ans[k-1] = (int)bucket[i].get(x);
        }
        
        return ans;
    }
}




// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         var map = new HashMap<Integer, Integer>();
//         for(var n: nums)
//             map.put(n, map.getOrDefault(n, 0) + 1);
        
//         var pq = new PriorityQueue<int[]>(Comparator.comparingInt(a -> a[0]));
//         for(var key : map.keySet()){
//             pq.offer(new int[]{map.get(key), key});
//             if(pq.size() > k)
//                 pq.poll();
//         }
        
//         int[] ans = new int[k];
//         int ptr = 0;
        
//         for(var x: pq)
//             ans[ptr++] = x[1];
        
//         return ans;
//     }
// }