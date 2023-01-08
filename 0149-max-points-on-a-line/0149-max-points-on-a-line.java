class Solution {
    public int maxPoints(int[][] pts) {
        int ans=1;
        for(int i=0; i<pts.length; ++i){
            HashMap<Double, Integer> map = new HashMap<>();
            for(int j=i+1; j<pts.length; ++j){
                Double slope = -0.0;
                if(pts[j][0] != pts[i][0]){
                    double up = (pts[j][1]-pts[i][1]);
                    double down = (pts[j][0]-pts[i][0]);
                    // slope = ((pts[j][1]-pts[i][1])/(pts[j][0]-pts[i][0]));
                    slope =  (up/down)==-0.0 ? 0.0 :(up/down);
                }
                if(map.containsKey(slope)) map.put(slope, map.get(slope)+1);
                else map.put(slope, 1);
                ans=Math.max(ans, map.get(slope)+1);
            }
        }
        return ans;
    }
}

// class Solution {
//     public int maxPoints(int[][] pts) {
//         int ans =1, n=pts.length;
//         for(int i=0; i<n; ++i){
//             HashSet<int[]> done = new HashSet<>();
//             for(int j=i+1; j<n; ++j){
//                 if(done.contains(new int[]{pts[j][0], pts[j][1]})) continue;
//                 int ptsOnLine=2;
//                 for(int k=j+1; k<n; k++){
//                     if(!done.contains(new int[]{pts[k][0], pts[k][1]}) && onLine(pts[i][0], pts[i][1], pts[j][0], pts[j][1], pts[k][0], pts[k][1])){
//                         ptsOnLine++;
//                         done.add(new int[]{pts[k][0], pts[k][1]});
//                     }
//                 }
//                 System.out.println(i+" "+j+" "+ptsOnLine);
//                 ans=Math.max(ans, ptsOnLine);
//             }
//         }
//         return ans;
//     }
//     private boolean onLine(int x1, int y1, int x2, int y2, int x, int y){
//         if(x2==x1) return x==x1;
//         if(y2==y1) return y==y1;
//         return (x-x1)/(x2-x1)==(y-y1)/(y2-y1);
//     }
// }