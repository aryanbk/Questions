class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        int[] p0 = points[0];
        
        for(int[] p: points){
            int dx = Math.abs(p[0] - p0[0]);
            int dy = Math.abs(p[1] - p0[1]);
            ans += Math.min(dx, dy) + Math.abs(dx - dy);
            p0 = p;
        }
        return ans;
    }
}