class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (a,b)->a[0]-b[0]);
        int mx = 0;
        for(int i=0; i<points.length-1; ++i){
            mx = Math.max(mx, points[i+1][0]-points[i][0]);
        }
        return mx;
    }
}