class Solution {
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int[][][] dp = new int[n][n][2]; 
        //[ans, max leaf node in this subtree]
        
        for(int i=n-1; i>=0; --i){
            for(int j=i; j<n; ++j){
                if(i==j){
                    dp[i][j] = new int[]{0, arr[i]};
                    continue;
                }
                
                int[] ans = new int[]{100000000, arr[i]};
                for(int k=i; k<j; ++k){
                    int[] left = dp[i][k];
                    int[] right = dp[k+1][j];
                    int val = left[1]*right[1]; // val of curr node
                    int sumt = left[0]+right[0]+val; // sumt of tree below - ans for currNode
                    if(sumt < ans[0])
                        ans = new int[]{sumt, Math.max(left[1], right[1])};
                }
                
                dp[i][j] = ans;
                
            }
        }
        return dp[0][n-1][0];
    }
}


// class Solution {
//     public int mctFromLeafValues(int[] arr) {
//         int n = arr.length;
//         int[][][] dp = new int[n][n][3]; 
//         //[ans, val of curr node, max leaf node in this subtree]
        
//         for(int i=n-1; i>=0; --i){
//             for(int j=i; j<n; ++j){
//                 if(i==j){
//                     dp[i][j] = new int[]{0, arr[i], arr[i]};
//                     continue;
//                 }
                
//                 int[] ans = new int[]{100000000, arr[i], arr[i]};
//                 for(int k=i; k<j; ++k){
//                     int[] left = dp[i][k];
//                     int[] right = dp[k+1][j];
//                     int val = left[2]*right[2]; // val of curr node
//                     int sumt = left[0]+right[0]+val; // sumt of tree below
//                     if(sumt < ans[0])
//                         ans = new int[]{sumt, val, Math.max(left[2], right[2])};
//                 }
                
//                 dp[i][j] = ans;
                
//             }
//         }
//         return dp[0][n-1][0];
//     }
// }



// // DP - memo
//
//
// class Solution {
//     Map<List<Integer>, int[]> map;
//     public int mctFromLeafValues(int[] arr) {
//         map = new HashMap<>();
//         return mcm(0, arr.length-1, arr)[0];
//     }
//     int[] mcm(int i, int j, int[] arr){
//         if(i==j)
//             return new int[]{0, arr[i], arr[i]};
        
//         List<Integer> key = List.of(i, j);
//         if(map.containsKey(key))
//             return map.get(key);
        
//         int[] ans = new int[]{100000000, 0, 0};
//         for(int k=i; k<j; ++k){
//             int[] left = mcm(i, k, arr);
//             int[] right = mcm(k+1, j, arr);
//             int val = left[2]*right[2];
//             int sumt = left[0]+right[0]+val;
//             if(sumt < ans[0]){
//                 ans = new int[]{sumt, val, Math.max(left[2], right[2])};
//             }
//         }
        
//         map.put(key, ans);
        
//         return ans;
//     }
// }



// // recurssion
//
// class Solution {
//     public int mctFromLeafValues(int[] arr) {
//         return mcm(0, arr.length-1, arr)[0];
//     }
//     int[] mcm(int i, int j, int[] arr){
//         if(i==j)
//             return new int[]{0, arr[i], arr[i]};
//         int[] ans = new int[]{100000000, 0, 0};
//         for(int k=i; k<j; ++k){
//             int[] left = mcm(i, k, arr);
//             int[] right = mcm(k+1, j, arr);
//             int val = left[2]*right[2];
//             int sumt = left[0]+right[0]+val;
//             if(sumt < ans[0]){
//                 ans = new int[]{sumt, val, Math.max(left[2], right[2])};
//             }
//         }
//         return ans;
//     }
// }