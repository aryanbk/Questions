class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n = limit+1;
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> c = new HashMap<>();
        int[] ans = new int[queries.length];
        int i =0;
        for(int[] q: queries){
            if(!c.containsKey(q[0])){
                c.put(q[0], q[1]);
                map.put(q[1], map.getOrDefault(q[1], 0)+1);
            }
            else{
                int prev = c.get(q[0]);
                c.put(q[0], q[1]);
                map.put(prev, map.get(prev)-1);
                if(map.get(prev)==0) map.remove(prev);
                map.put(q[1], map.getOrDefault(q[1], 0)+1);
            }
            ans[i] = map.size();
            ++i;
        }
        return ans;
    }
}