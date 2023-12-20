class Solution {
    public int minScoreTriangulation(int[] val) {
        int n = val.length;
        int[][] dp = new int[n][n];
        
        for(int i=n-1; i>=0; --i){
            for(int j=i+2; j<n; ++j){
                long ans = Integer.MAX_VALUE;
                for(int k=i+1; k<j; ++k){
                    long cur = val[i]*val[j]*val[k] + dp[i][k] + dp[k][j];
                    ans = Math.min(ans, cur);
                }
                dp[i][j] = (int)ans;
            }
        }
        return dp[0][n-1];
        
    }
}



// class Solution {
//     Integer[][] memo;
    
//     public int minScoreTriangulation(int[] values) {
//         int n = values.length;
//         memo = new Integer[n][n];
//         return mcm(0, n-1, values);
//     }
    
//     int mcm(int i, int j, int[] val){
//         if(j-i<2) return 0;
        
//         if(memo[i][j] != null) return memo[i][j];
        
//         long ans = Integer.MAX_VALUE;
//         for(int k=i+1; k<j; ++k){
//             long cur = val[i]*val[j]*val[k] + mcm(i, k, val) + mcm(k, j, val);
//             ans = Math.min(ans, cur);
//         }
        
//         memo[i][j] = (int)ans;
//         return memo[i][j];
//     }
// }

// // recurssion - TLE
//
// class Solution {
//     public int minScoreTriangulation(int[] values) {
//         return (int)mcm(0, values.length-1, values);
//     }
//     long mcm(int i, int j, int[] val){
//         if(j-i<2) return 0;
        
//         long ans = Integer.MAX_VALUE;
//         for(int k=i+1; k<j; ++k){
//             long cur = val[i]*val[j]*val[k] + mcm(i, k, val) + mcm(k, j, val);
//             ans = Math.min(ans, cur);
//         }
//         return ans;
//     }
// }




// // failed attemps
//
// class Solution {
//     int n;

//     public int minScoreTriangulation(int[] values) {
//         n = values.length;
//         long ans = Integer.MAX_VALUE;
//         for (int i = 0; i < n; ++i) {
//             long cur = help(i, (i + 2) % n, true, values);
//             ans = Math.min(ans, cur);
//             System.out.println(cur);
//         }
//         return (int) ans;
//     }

//     long help(int i, int j, boolean take, int[] val) {
//         if ((j + 2) % n == i) {
//             if (take) return val[i] * val[j % n] * val[(j + 1) % n];
//             return val[i] * val[j % n] * val[(j + 1) % n] + val[j] * val[(j - 1 + n) % n] * val[i];
//         }

//         long ans = val[i] * val[j % n] * val[(j - 1 + n) % n] + help(i, (j + 1) % n, false, val);
//         if (!take) {
//             long one = val[j % n] * val[(j - 1 + n) % n] * val[(j + 1) % n];
//             long two = val[i] * val[(j - 1 + n) % n] * val[(j + 1) % n];
//             ans = Math.min(ans, one + two + help(i, (j + 1) % n, true, val));
//         }
//         return ans;
//     }
// }




// // class Solution {
// //     int n;
// //     public int minScoreTriangulation(int[] values) {
// //         n = values.length;
// //         long ans = Integer.MAX_VALUE;
// //         for (int i = 0; i < n; ++i){
// //             long cur = help(i, (i + 2) % n, true, values);
// //             ans = Math.min(ans, cur);
// //             System.out.println(cur);
// //         }
// //         return (int) ans;
// //     }

// //     long help(int i, int j, boolean take, int[] val) {
// //         if ((j+2)%n == i) {
// //             if(take) return val[i]*val[(j)%n]*val[(j+1)%n];
// //             return val[i]*val[(j)%n]*val[(j+1)%n] + val[j]*val[(j-1+n)%n]*val[i];
// //         }

// //         long ans = val[i] * val[j % n] * val[(j - 1 + n) % n] + help(i, (j + 1) % n, false, val);
// //         if (!take) {
// //             long one = val[j % n] * val[(j - 1 + n) % n] * val[(j + 1) % n];
// //             long two = val[i] * val[(j - 1 + n) % n] * val[(j + 1) % n];
// //             ans = Math.min(ans, one + two + help(i, (j + 1) % n, true, val));
// //         }
// //         return ans;
// //     }
// // }



// // // class Solution {
// // //     int n;
// // //     public int minScoreTriangulation(int[] values) {
// // //         n = values.length;
// // //         long ans = Integer.MAX_VALUE;
// // //         for(int i=0; i<n; ++i)
// // //             ans = Math.min(ans, help(i, (i+2)%n, true, values));
// // //         return (int)ans;
// // //     }
// // //     long help(int i, int j, boolean take, int[] val){
// // //         if((j+1)%n == i){
// // //             return take ? Integer.MAX_VALUE : 0;
// // //         }
        
// // //         long ans = val[i]*val[j%n]*val[(j-1+n)%n] + help(i, j+1, false, val);
// // //         if(!take){
// // //             long one = val[j%n]*val[(j-1+n)%n]*val[(j+1)%n];
// // //             long two = val[i]*val[(j-1+n)%n]*val[(j+1)%n];
// // //             ans = Math.min(ans, one+two+help(i, j+1, true, val));
// // //         }
// // //         return ans;
// // //     }
// // // }


// // // // wont work for big polygons
// // // // first attempt
// // //
// // // class Solution {
// // //     public int minScoreTriangulation(int[] values) {
// // //         int n = values.length;
// // //         long ans = Integer.MAX_VALUE;
// // //         for(int i=0; i<n; ++i){
// // //             long curr = 0;
// // //             for(int j=1; j<n-1; ++j){
// // //                 curr += values[(i+j)%n]*values[(i+j+1)%n]*values[i];
// // //             }
// // //             ans = Math.min(ans, curr);
// // //         }
// // //         return (int)ans;
// // //     }
// // // }