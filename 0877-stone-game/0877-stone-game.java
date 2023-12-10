class Solution {
    int[][] memo;
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        memo = new int[n][n];
        for(int[] row: memo) Arrays.fill(row, -1);
        return solve(0, n-1, piles) > 0;
    }
    private int solve(int i, int j, int[] piles){
        if(i>j) 
            return 0;
        
        if(memo[i][j] != -1) return memo[i][j];
        
        if((j-i)%2==1){ //alice
            memo[i][j] = Math.max(piles[i]+solve(i+1, j, piles), piles[j]+solve(i, j-1, piles));
        }
        else{ // bob
            memo[i][j] = Math.min(-piles[i]+solve(i+1, j, piles), -piles[j]+solve(i, j-1, piles));
        }
        return memo[i][j];
    }
}