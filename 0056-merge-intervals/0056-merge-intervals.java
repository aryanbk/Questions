class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);
        
        for(int i=1; i<intervals.length; ++i){
            int[] cur = intervals[i];
            int[] prev = ans.get(ans.size() - 1);
            if(prev[1] >= cur[0])
                prev[1] = Math.max(cur[1], prev[1]);
            else
                ans.add(cur);
        }
        
        int[][] ans2 = new int[ans.size()][2];
        for(int i=0; i<ans.size(); ++i)
            ans2[i] = ans.get(i);
        return ans2;
    }
}