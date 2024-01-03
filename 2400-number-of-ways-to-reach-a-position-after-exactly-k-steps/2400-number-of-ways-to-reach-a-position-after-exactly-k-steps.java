class Solution {
    
    // Map<List<Integer>, Integer> map;
    Integer[][] memo;
    int MOD = 1_000_000_007;
    
    public int numberOfWays(int startPos, int endPos, int k) {
        memo = new Integer[4002][1001];
        return help(startPos, endPos, k);
    }
    
    int help(int s, int e, int k){
        if(k==0) return s==e ? 1 : 0;
        if(Math.abs(s-e) > k) return 0; // TLE
        
        if(memo[s+2000][k] == null)
            memo[s+2000][k] = (help(s+1, e, k-1) + help(s-1, e, k-1))%MOD;
        
        return memo[s+2000][k];
    }
}

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