class Solution {
    int[] pre;
    int[][] memo;
    
    public int stoneGameV(int[] val) {
        int n = val.length;
        pre = new int[n+1];
        for(int i=1; i<=n; ++i){
            pre[i] = pre[i-1] + val[i-1];
        }
        // System.out.println(Arrays.toString(pre));
        memo = new int[n+1][n+1];
        for(int[] row: memo) Arrays.fill(row, -1);
        
        return mcm(0, n-1, val);
    }
    
    private int mcm(int i, int j, int[] val){
        if(i>=j) return 0;
        // if(i==j) return val[i];
        
        if(memo[i][j] != -1) return memo[i][j];
        
        // int sumt = pre[j+1] - pre[i];
        int ans = 0;
        for(int k=i; k<j; ++k){
            int sumt1 = pre[k+1] - pre[i];
            int sumt2 = pre[j+1] - pre[k+1];
            // System.out.println(sumt+" "+curSum);
            if(sumt1 < sumt2){
                ans = Math.max(ans, sumt1 + mcm(i, k, val));
            }
            else if(sumt1 > sumt2){
                ans = Math.max(ans, sumt2 + mcm(k+1, j, val));
            }
            else{
                int newAns = Math.max(mcm(i, k, val), mcm(k+1, j, val)) + sumt1;
                ans = Math.max(ans, newAns);
            }
        }
        
        memo[i][j] = ans;
        return ans;
    }
}


// // mcm - recursion
// class Solution {
//     int[] pre;
//     public int stoneGameV(int[] val) {
//         int n = val.length;
//         pre = new int[n+1];
        
//         for(int i=1; i<=n; ++i){
//             pre[i] = pre[i-1] + val[i-1];
//         }
        
//         return mcm(0, n-1, val);
//     }
//     private int mcm(int i, int j, int[] val){
//         if(i>j) return 0;
//         if(i==j-1) return val[i];
//         int sumt = pre[j+1] - pre[i];
//         int ans = 0;
//         for(int k=i; k<j; ++k){
//             int curSum = pre[k+1] - pre[i];
//             if(2*curSum < sumt){
//                 ans = Math.max(ans, curSum + mcm(i, k, val));
//             }
//             else if(2*curSum > sumt){
//                 ans = Math.max(ans, sumt-curSum + mcm(k+1, j, val));
//             }
//             else{
//                 int newAns = Math.max(mcm(i, k, val), mcm(k+1, j, val)) + sumt;
//                 ans = Math.max(ans, newAns);
//             }
//         }
//         return ans;
//     }
// }