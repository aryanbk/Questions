class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] dp = new long[n+1];
        dp[1] = 1;
        long active = 0;
        int MOD = 1_000_000_007;
        long ans = 0;
        
        for(int i=2; i<n+1; ++i){
            dp[i] = active = (active + dp[Math.max(i-delay, 0)] - 
                              dp[Math.max(i-forget, 0)] + MOD) % MOD;
            
            if(i>n-forget)
                ans = (ans + dp[i]) % MOD;
        
        }
        return n-forget > 0 ? (int)ans : (int)ans + 1;
    }
}



// class Solution {
//     public int peopleAwareOfSecret(int n, int delay, int forget) {
//         long[] dp = new long[n+1];
//         dp[1] = 1;
//         long active = 0;
//         int MOD = 1_000_000_007;
        
//         for(int i=2; i<n+1; ++i){
//             active = (active + dp[Math.max(i-delay, 0)] + MOD) % MOD;
//             active = (active - dp[Math.max(i-forget, 0)] + MOD) % MOD;
//             dp[i] = active;
//         }
        
//         long ans = 0;
//         for(int i = n-forget+1; i<n+1; ++i){
//             ans = (ans + dp[i])%MOD;
//         }
//         return (int)ans;
//     }
// }


// // works but gives TLE
// // slow
//
// class Solution {
//     public int peopleAwareOfSecret(int n, int delay, int forget) {
//         int day = 0;
//         Queue<int[]> q = new LinkedList<>();
//         q.offer(new int[]{delay, forget});
        
//         for(int i=0; i<n-1; ++i){
//             int l = q.size();
//             for(int j=0; j<l; ++j){
//                 int d = q.peek()[0];
//                 int f = q.peek()[1];
//                 q.poll();
                
//                 if(f<=1)
//                     continue;
                
//                 q.offer(new int[]{d-1, f-1});
//                 if(d <=  1){
//                     q.offer(new int[]{delay, forget});
//                 }
//             }
//         }
        
//         return q.size();
//     }
// }


// // DP - 2
// class Solution {
//     public int peopleAwareOfSecret(int n, int delay, int forget) {
//         long[] dp = new long[n+1];
//         dp[1] = 1;
//         long active = 0;
//         int MOD = 1_000_000_007;
        
//         for(int i=2; i<n+1; ++i)
//             dp[i] = active = (active + dp[Math.max(i-delay, 0)] - 
//                               dp[Math.max(i-forget, 0)] + MOD) % MOD;
        
//         long ans = 0;
//         for(int i = n-forget+1; i<n+1; ++i)
//             ans = (ans + dp[i])%MOD;
        
//         return (int)ans;
//     }
// }


// // DP
//
// class Solution {
//     public int peopleAwareOfSecret(int n, int delay, int forget) {
//         long[] dp = new long[n+1];
//         dp[1] = 1;
//         long active = 0;
//         int MOD = 1_000_000_007;
        
//         for(int i=2; i<n+1; ++i){
//             active = (active + dp[Math.max(i-delay, 0)] + MOD) % MOD;
//             active = (active - dp[Math.max(i-forget, 0)] + MOD) % MOD;
//             dp[i] = active;
//         }
        
//         long ans = 0;
//         for(int i = n-forget+1; i<n+1; ++i){
//             ans = (ans + dp[i])%MOD;
//         }
//         return (int)ans;
//     }
// }


// // works but gives TLE
// // slow
//
// class Solution {
//     public int peopleAwareOfSecret(int n, int delay, int forget) {
//         int day = 0;
//         Queue<int[]> q = new LinkedList<>();
//         q.offer(new int[]{delay, forget});
        
//         for(int i=0; i<n-1; ++i){
//             int l = q.size();
//             for(int j=0; j<l; ++j){
//                 int d = q.peek()[0];
//                 int f = q.peek()[1];
//                 q.poll();
                
//                 if(f<=1)
//                     continue;
                
//                 q.offer(new int[]{d-1, f-1});
//                 if(d <=  1){
//                     q.offer(new int[]{delay, forget});
//                 }
//             }
//         }
        
//         return q.size();
//     }
// }