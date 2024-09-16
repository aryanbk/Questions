class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] time = new int[timePoints.size()];
        
        for(int i=0; i<n; ++i){
            String[] cur = timePoints.get(i).split(":");
            time[i] = (Integer.parseInt(cur[0])*60) + Integer.parseInt(cur[1]);
        }
        
        Arrays.sort(time);
        int ans = Integer.MAX_VALUE; // difference
        for(int i=0; i<n-1; ++i)
            ans = Math.min(ans, Math.abs(time[i+1] - time[i]));
        
        ans = Math.min(ans, Math.abs(time[0]+1440 - time[n-1]));
        
        return ans;
    }
}