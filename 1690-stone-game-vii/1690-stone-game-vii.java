class Solution {
    int[][] memo;
    int[] pre;
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        
        pre = new int[n+1];
        for(int i=1; i<=n; i++) pre[i] = pre[i-1] + stones[i-1];
        
        memo = new int[n+1][n+1];
        for(int[] row: memo) Arrays.fill(row, -1);
        
        return solve(0, n-1, stones);
    }
    private int solve(int i, int j, int[] stones){
        if(j<=i) return 0;
        int sumt = pre[j+1] - pre[i];
        if(memo[i][j] != -1) return memo[i][j];
        
        memo[i][j] = Math.max(sumt - stones[i] - solve(i+1, j, stones), sumt - stones[j] - solve(i, j-1, stones));
        return memo[i][j];
    }
}

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