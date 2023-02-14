class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        
        for(char c : tasks) map.put(c, map.getOrDefault(c, 0)+1);
        for(Integer a: map.values()) pq.offer(a);
        
        int time = 0;
        while(!pq.isEmpty()){
            Stack<Integer> stk = new Stack<>();
            int i=0;
            
            while(!pq.isEmpty() && i<n+1){
                int popped = pq.poll();
                if(popped!=1) stk.add(popped-1);
                i++;
                if(pq.isEmpty() && stk.isEmpty()) return time+i;
            }
            
            while(!stk.isEmpty()) pq.offer(stk.pop());
            time += n+1;
        }
        return time;
    }
}