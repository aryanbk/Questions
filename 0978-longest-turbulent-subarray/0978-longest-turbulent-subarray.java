class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int ans = 1;
        int[][] dp = new int[n][2];
        dp[0][0] = dp[0][1] = 1;
        
        for(int i=1; i<n; ++i){
            if(arr[i]>arr[i-1]){
                dp[i][1] = dp[i-1][0] + 1;
                dp[i][0] = 1;
                ans = Math.max(ans, dp[i][1]);
            }
            else if(arr[i]<arr[i-1]){
                dp[i][0] = dp[i-1][1] + 1;
                dp[i][1] = 1;
                ans = Math.max(ans, dp[i][0]);
            }
            else{
                dp[i] = new int[]{1, 1};
            }
        }
        return ans;
    }
}


// // No DP - sliding window
//
// class Solution {
//     public int maxTurbulenceSize(int[] arr) {
//         int n = arr.length;
//         int ans = 1;
        
//         for(int r=1, l=0; r<n; ++r){
//             if(arr[r] == arr[r-1])
//                 l=r;
//             else if(r>1 && arr[r]>arr[r-1] == arr[r-1]>arr[r-2])
//                 l = r -1;
            
//             ans = Math.max(ans, r-l+1);
//         }
        
//         return ans;
//     }
// }

// // tried to contribute a testcase
//
// class Solution {
//     public int maxTurbulenceSize(int[] arr) {
//         int n = arr.length;
//         if(n==1) return 1;
//         if(n==2) return 1;
//         int ans = 2;
//         int l = 0;
//         while(l+1<n && arr[l]==arr[l+1]) l++;
//         boolean prev = arr[1]-arr[0] < 0;
        
//         for(int r=l+1; r<n; ++r){ // WA #2
//             boolean curr = arr[r] > arr[r-1];
//             if(prev == curr){
//                 l = r-1;
//             }
//             if(arr[r]==arr[r-1]) l=r; // WA #1
//             ans = Math.max(ans, r-l+1);
//             prev = curr;
//         }
        
//         return ans;
//     }
// }