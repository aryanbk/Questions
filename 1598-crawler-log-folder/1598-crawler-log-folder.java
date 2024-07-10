class Solution {
    public int minOperations(String[] logs) {
        int depth = 0;
        for(String log: logs){
            if(log.equals("./")) continue;
            else if(log.equals("../")) depth = Math.max(depth-1, 0);
            else ++depth;
        }
        return Math.max(depth, 0);
    }
}