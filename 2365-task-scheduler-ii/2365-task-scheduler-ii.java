class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        long time = 0;
        Map<Integer, Long> map = new HashMap<>();
        
        for(int ptr=0; ptr<tasks.length; ++ptr){
            if(map.containsKey(tasks[ptr]) && map.get(tasks[ptr])>time){
                time = (long)map.get(tasks[ptr]);
                ptr--;
            }
            else{
                map.put(tasks[ptr], time+space+1);
                time++;
            }
        }
        
        return time;
    }
}