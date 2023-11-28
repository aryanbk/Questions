class Solution {
    int[][] memo;
    public int integerBreak(int n) {
        if(n<4) return n-1;
        memo = new int[n+1][n+1];
        for(int[] m1: memo) Arrays.fill(m1, -1);
        return help(1, n);
    }
    private int help(int i, int n){
        if(n==0) return 1;
        if(i>n) return 0;
        if(memo[i][n] != -1) return memo[i][n];
        memo[i][n] = help(i+1, n);
        if(n>=i) memo[i][n] = Math.max(memo[i][n], help(i, n-i)*i);
        return memo[i][n];
    }
}