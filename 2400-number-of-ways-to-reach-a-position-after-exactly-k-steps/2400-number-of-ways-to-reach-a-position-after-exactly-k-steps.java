class Solution {
    public int numberOfWays(int startPos, int endPos, int k) {
        int[][] dp = new int[2*k + 2][k+1];
        int MOD = 1_000_000_007;
        int end = k + Math.abs(startPos - endPos);
        
        if(end >= dp.length)
            return 0; // Runtime Error #2
        dp[end][0] = 1;
        
        for(int kk=1; kk<=k; ++kk){
            for(int s=kk; s<dp.length-kk; ++s){
                dp[s][kk] = (dp[s-1][kk-1] + dp[s+1][kk-1])%MOD;
            }
        }
        
        return dp[k][k];
    }
}


// // DP - memo
//
// class Solution {    
//     Integer[][] memo;
//     int end;
//     int MOD = 1_000_000_007;
    
//     public int numberOfWays(int startPos, int endPos, int k) {
//         memo = new Integer[2*k + 2][k+1];
//         end = k + Math.abs(startPos - endPos);
//         return help(k, k);
//     }
    
//     int help(int s, int k){
//         if(k==0) return s==end ? 1 : 0;
//         if(Math.abs(s-end) > k) return 0; // TLE
        
//         if(memo[s][k] == null)
//             memo[s][k] = (help(s+1, k-1) + help(s-1, k-1))%MOD;
        
//         return memo[s][k];
//     }
// }



// class Solution {
//     Integer[][] memo;
//     int MOD = 1_000_000_007;
    
//     public int numberOfWays(int startPos, int endPos, int k) {
//         memo = new Integer[4002][1001];
//         return help(startPos, endPos, k);
//     }
    
//     int help(int s, int e, int k){
//         if(k==0) return s==e ? 1 : 0;
//         if(Math.abs(s-e) > k) return 0; // TLE
        
//         if(memo[s+2000][k] == null)
//             memo[s+2000][k] = (help(s+1, e, k-1) + help(s-1, e, k-1))%MOD;
        
//         return memo[s+2000][k];
//     }
// }




// // BFS - TLE
//
// class Solution {
//     public int numberOfWays(int s, int e, int k) {
//         Queue<Integer> q = new LinkedList<>();
//         q.offer(s);
//         for(int i=0; i<k; ++i){
//             int l = q.size();
//             for(int j=0; j<l; ++j){
//                 int pos = q.poll();
//                 q.offer(pos+1);
//                 q.offer(pos-1);
//             }
//         }
        
//         int ans = 0;
//         for(var x: q)
//             ans += x==e ? 1 : 0;
//         return ans;
//     }
// }