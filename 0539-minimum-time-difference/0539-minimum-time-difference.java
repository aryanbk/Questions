class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        boolean[] f = new boolean[24*60];
        
        for(int i=0; i<n; ++i){
            String[] cur = timePoints.get(i).split(":");
            int minutes = (Integer.parseInt(cur[0])*60) + Integer.parseInt(cur[1]);
            if(f[minutes]) return 0;
            f[minutes] = true;
        }
        
        int prev = -1;
        int first = -1;
        int ans = Integer.MAX_VALUE; // difference
        
        for(int i=0; i<24*60; ++i){
            if(f[i]){
                if(prev != -1) ans = Math.min(ans, i-prev);
                prev = i;
                if(first == -1) first = i;
            }
        }
        ans = Math.min(ans, first+(24*60) - prev);
        return ans;
    }
}



// class Solution {
//     public int findMinDifference(List<String> timePoints) {
//         int n = timePoints.size();
//         int[] time = new int[timePoints.size()];
        
//         for(int i=0; i<n; ++i){
//             String[] cur = timePoints.get(i).split(":");
//             time[i] = (Integer.parseInt(cur[0])*60) + Integer.parseInt(cur[1]);
//         }
        
//         Arrays.sort(time);
//         int ans = Integer.MAX_VALUE; // difference
//         for(int i=0; i<n-1; ++i)
//             ans = Math.min(ans, Math.abs(time[i+1] - time[i]));
        
//         ans = Math.min(ans, Math.abs(time[0]+1440 - time[n-1]));
        
//         return ans;
//     }
// }