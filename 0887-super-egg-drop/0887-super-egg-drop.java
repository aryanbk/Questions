// class Solution {
//     public int superEggDrop(int k, int n) {
//         return mcm(0, n, k);
//     }
    
//     private int mcm(int i, int n, int egg){
//         if (i>n) return 0;
//         if (i==n) return 1;
        
//         int ans = 100000;
        
//         if(egg==1) return n-i;
        
//         for(int k=i+1; k<=n; ++k){
//             ans = Math.min(ans, 1+Math.max(mcm(k, n, egg), mcm(i, k-1, egg-1)));
//         }
        
//         return ans;
//     }
// }


class Solution {
    int[][] memo;
    public int superEggDrop(int k, int n) {
        memo = new int[k+1][n+1];
        for(int[] row: memo) Arrays.fill(row, -1);
        return Math.min(n, mcm(k, n));
    }
    
    private int mcm(int egg, int n){
        if (n<2) return n;
        if (egg==1) return n;
        
        if(memo[egg][n] != -1) return memo[egg][n];
        
        int ans = 100000;
        
//         for(int i=1; i<=n; ++i){
            // int left = memo[egg-1][i-1] != -1 ? memo[egg-1][i-1] : mcm(egg-1, i-1);
            // int right = memo[egg][n-i] != -1 ? memo[egg][n-i] : mcm(egg, n-i);

//             ans = Math.min(ans, 1 + Math.max(left, right));
//         }
        
//         memo[egg][n] = ans;
//         return ans;
        
        int lo = 1;
        int hi = n;
        while(lo<=hi){
            int i = lo + (hi-lo)/2; //mid
            int left = memo[egg-1][i-1] != -1 ? memo[egg-1][i-1] : mcm(egg-1, i-1);
            int right = memo[egg][n-i] != -1 ? memo[egg][n-i] : mcm(egg, n-i);
            
            ans = Math.min(ans, 1+Math.max(left, right));
            if(left==right){
                break;
            } else if(left<right) {
                lo = i+1;
            } else {
                hi = i - 1;
            }
        }
        
        memo[egg][n] = ans;
        return ans;
        
    }
}


// class Solution {
//     public int superEggDrop(int k, int n) {
//         // Create a memoization array to store results of subproblems
//         int[][] memo = new int[n + 1][k + 1];
//         return mcm(0, n, k, memo);
//     }
    
//     private int mcm(int i, int n, int egg, int[][] memo) {
//         // If already calculated for this subproblem, return memoized result
//         if (i > n) return 0;
//         if (i == n) return 1;
//         if (egg == 0) return 100000;

//         // Check if the result is already calculated
//         if (memo[i][egg] != 0) return memo[i][egg];
        
//         int ans = 100000;
        
//         for (int k = i; k <= n; ++k) {
//             int breakEgg = mcm(k + 1, n, egg - 1, memo);
//             int noBreakEgg = mcm(i, k - 1, egg, memo);
//             int attempts = 1 + Math.max(breakEgg, noBreakEgg);
//             ans = Math.min(ans, attempts);
//         }
        
//         // Store the result in the memoization array
//         memo[i][egg] = ans;
        
//         return ans;
//     }
// }
