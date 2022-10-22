class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int l=triangle.size();
        int[][] dp = new int[l][triangle.get(l-1).size()];
        for(int[] row: dp)
            Arrays.fill(row, -1);
        return helper(triangle, 0, 0, dp);
    }
    int helper(List<List<Integer>> list, int row, int col, int[][] dp){
        if(row==list.size()-1){
            dp[row][col]=list.get(row).get(col);
            return dp[row][col];
        }
        if(dp[row][col] == -1)
            dp[row][col] = Math.min(helper(list, row+1, col, dp), helper(list, row+1, col+1, dp))
                + list.get(row).get(col);
        return dp[row][col];
    }
}