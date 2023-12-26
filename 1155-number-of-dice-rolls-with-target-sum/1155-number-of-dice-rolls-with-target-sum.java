class Solution {
    int MOD = 1_000_000_007;
    Integer[][] memo = new Integer[31][1001];
    public int numRollsToTarget(int n, int k, int target) {
        if(n==0) return target==0 ? 1 : 0;
        
        if(memo[n][target] != null) return memo[n][target];
        
        memo[n][target] = 0;
        
        for(int x=1; x<=k && x<=target; ++x) 
            memo[n][target] = (memo[n][target] + numRollsToTarget(n-1, k, target-x))%MOD;
        
        return memo[n][target];
    }
}


// // Recursion
// // O(k^n)
//
// class Solution {
//     int MOD = 1_000_000_007;
//     public int numRollsToTarget(int n, int k, int target) {
//         if(n==0) return target==0 ? 1 : 0;
//         int ans = 0;
        
//         for(int x=1; x<=k && x<=target; ++x) ans = (ans + numRollsToTarget(n-1, k, target-x))%MOD;
//         return ans;
//     }
// }