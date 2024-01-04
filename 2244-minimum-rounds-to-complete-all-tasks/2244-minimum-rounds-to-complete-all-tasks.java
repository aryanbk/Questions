class Solution {
    public int minimumRounds(int[] tasks) {
        var map = new HashMap<Integer, Integer>();
        for(int n: tasks)
            map.put(n, map.getOrDefault(n, 0) + 1);
        
        int ans = 0;
        for(int key : map.keySet()){
            if(map.get(key) == 1) return -1;
            ans += (map.get(key) + 2)/3;
        }
        
        return ans;
    }
}


// https://leetcode.com/problems/minimum-number-of-operations-to-make-array-empty/