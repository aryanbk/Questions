class Solution {
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[][] dp = new int[n+1][n+1];
        
        int[] pre = new int[n+1];
        for(int i=1; i<=n; i++) pre[i] = pre[i-1] + stones[i-1];
        
        for(int i=n-1; i>=0; --i){
            for(int j=i+1; j<n; ++j){
                int sumt = pre[j+1] - pre[i];
                dp[i][j] = Math.max(sumt - stones[i] - dp[i+1][j], sumt - stones[j] - dp[i][j-1]);
            }
        }
        
        return dp[0][n-1];
    }
}




// // DP - memo O(n*n)
//
// class Solution {
//     int[][] memo;
//     int[] pre;
//     public int stoneGameVII(int[] stones) {
//         int n = stones.length;
        
//         pre = new int[n+1];
//         for(int i=1; i<=n; i++) pre[i] = pre[i-1] + stones[i-1];
        
//         memo = new int[n+1][n+1];
//         for(int[] row: memo) Arrays.fill(row, -1);
        
//         return solve(0, n-1, stones);
//     }
//     private int solve(int i, int j, int[] stones){
//         if(j<=i) return 0;
//         int sumt = pre[j+1] - pre[i];
//         if(memo[i][j] != -1) return memo[i][j];
        
//         memo[i][j] = Math.max(sumt - stones[i] - solve(i+1, j, stones), sumt - stones[j] - solve(i, j-1, stones));
//         return memo[i][j];
//     }
// }




// // recursive
//
// class Solution {
//     int[] pre;
//     public int stoneGameVII(int[] stones) {
//         int n = stones.length;
//         pre = new int[n+1];
//         for(int i=1; i<=n; i++) pre[i] = pre[i-1] + stones[i-1];
        
//         return solve(0, n-1, stones);
//     }
//     private int solve(int i, int j, int[] stones){
//         if(j<=i) return 0;
//         int sumt = pre[j+1] - pre[i];
//         return Math.max(sumt - stones[i] - solve(i+1, j, stones), sumt - stones[j] - solve(i, j-1, stones));
//     }
// }