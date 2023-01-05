// class Solution {
//     public int findMinArrowShots(int[][] points) {
//         Arrays.sort(points, (a,b)->a[0]-b[0]); // here a[0]-b[0] wont work because it might go outside integer limit
//         int l = points.length, start = points[l-1][0], ans = 0;
//         for(int i=l-2; i>=0; --i){
//             if(points[i][1] < start){
//                 ans++;
//                 start = points[i][0];
//             }
//         }
//         return ans+1;
//     }
// }



class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b) -> Integer.compare(a[0], b[0] ));
        int l = points.length, start = points[l-1][0], ans = 0;
        for(int i=l-2; i>=0; --i){
            if(points[i][1] < start){
                ans++;
                start = points[i][0];
            }
        }
        return ans+1;
    }
}