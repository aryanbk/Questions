class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        // Arrays.sort(intervals, Comparator.comparingInt(a -> a[0])); // WA
        Arrays.sort(intervals, (a, b) -> {
            return a[0]==b[0] ? b[1]-a[1] : a[0]-b[0];
        });
        
        int end = 0;
        int covered = 0;
        
        for(int i=0; i<intervals.length; ++i){
            if(intervals[i][1] <= end)
                ++covered;
            else
                end = intervals[i][1];
        }
        
        return intervals.length - covered;
    }
}