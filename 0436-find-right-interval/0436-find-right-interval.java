// // O(n log n)
// // O(n)
//
class Solution {
    public int[] findRightInterval(int[][] intvl) {
        int n = intvl.length;
        
        int[][] start = new int[n][2];
        
        for(int i=0; i<n; ++i)
            start[i] = new int[]{intvl[i][0], i};
        
        Arrays.sort(start, (a,b)->a[0]-b[0]);
        
        int[] ans = new int[n];
        for(int i=0; i<n; ++i){
            ans[i] = bs(intvl[i][1], start);
        }
        return ans;
        
    }
    
    int bs(int x, int[][] start){
        int i = 0;
        int j = start.length-1;
        int ans = -1;
        
        while(i<=j){
            int mid = i + (j-i)/2;
            if(start[mid][0] >= x){
                ans = mid;
                j = mid -1;
            }
            else{
                i = mid + 1;
            }
        }
        return ans == -1 ? -1 : start[ans][1];
    }
}

// // wont work 
//
// class Solution {
//     public int[] findRightInterval(int[][] intvl) {
//         int n = intvl.length;
        
//         List<List<Integer>> list = new ArrayList<>();
//         for(int i = 0; i<intvl.length; ++i){
//             List<Integer> l = List.of(intvl[i][0], intvl[i][1], i);
//             list.add(l);
//         }
        
//         Collections.sort(list, (a, b) -> {
//             return a.get(1)==b.get(1) ? a.get(0)-b.get(0) : a.get(1)-b.get(1);
//         });
        
//         int[] ans = new int[n];
//         for(int i=0; i<n; ++i){
//             int j = i+1;
//             while(j<n && list.get(j).get(0) < list.get(i).get(1)){
//                 ++j;
//             }
//             ans[list.get(i).get(2)] = j == n ? -1 : list.get(j).get(2);
//         }
        
//         return ans;
//     }
    
//     int bs(int i, int x, List<List<Integer>> list){
//         int j = list.size()-1;
//         int ans = -1;
//         while(i<=j){
//             int mid = i + (j-i)/2;
//             if(list.get(mid).get(0) >= x){
//                 ans = mid;
//                 j = mid -1;
//             }
//             else{
//                 i = mid + 1;
//             }
//         }
//         return ans == -1 ? -1 : list.get(ans).get(2);
//     }
// }


// // Wrong approch WA #1
//
// class Solution {
//     public int[] findRightInterval(int[][] intvl) {
//         int n = intvl.length;
        
//         List<List<Integer>> list = new ArrayList<>();
//         for(int i = 0; i<intvl.length; ++i){
//             List<Integer> l = List.of(intvl[i][0], intvl[i][1], i);
//             list.add(l);
//         }
        
//         Collections.sort(list, (a, b) -> {
//             return a.get(1)==b.get(1) ? a.get(0)-b.get(0) : a.get(1)-b.get(1);
//         });
        
//         int[] ans = new int[n];
//         for(int i=0; i<n; ++i){
//             ans[list.get(i).get(2)] = bs(i, list.get(i).get(1), list);
//         }
        
//         return ans;
//     }
    
//     int bs(int i, int x, List<List<Integer>> list){
//         int j = list.size()-1;
//         int ans = -1;
//         while(i<=j){
//             int mid = i + (j-i)/2;
//             if(list.get(mid).get(0) >= x){
//                 ans = mid;
//                 j = mid -1;
//             }
//             else{
//                 i = mid + 1;
//             }
//         }
//         return ans == -1 ? -1 : list.get(ans).get(2);
//     }
// }



// // first attempt - wrong approch
//
// class Solution {
//     public int[] findRightInterval(int[][] intvl) {
//         int n = intvl.length;
        
//         List<List<Integer>> list = new ArrayList<>();
//         for(int i = 0; i<intvl.length; ++i){
//             List<Integer> l = List.of(intvl[i][0], intvl[i][1], i);
//             list.add(l);
//         }
//         Collections.sort(list, (a, b) -> {
//             return a.get(1)==b.get(1) ? a.get(0)-b.get(0) : a.get(1)-b.get(1);
//         });
//         System.out.println(list);
//         int[] ans = new int[n];
//         for(int i=0; i<n; ++i){
//             if(i==n-1 || list.get(i).get(1) > list.get(i+1).get(0)){
//                 ans[list.get(i).get(2)] = -1;
//             }
//             else{
//                 ans[list.get(i).get(2)] = list.get(i+1).get(2);
//             }
//         }
        
//         return ans;
//     }
// }