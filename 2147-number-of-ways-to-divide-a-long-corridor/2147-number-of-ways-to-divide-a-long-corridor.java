// dp memo
//
class Solution {
    int MOD = 1_000_000_007;
    int[][] memo;
    
    public int numberOfWays(String cor) {
        memo = new int[cor.length()][3];
        for(int[] m1: memo) Arrays.fill(m1, -1);
        
        return help(0, 0, cor);
    }
    
    private int help(int i, int seats, String cor){
        if(seats >= 3) return 0;
        if(i==cor.length()) return seats==2 ? 1 : 0;
        if(memo[i][seats] != -1) return memo[i][seats];

        int newSeat = cor.charAt(i)=='S' ? 1 : 0;
        memo[i][seats] = help(i+1, seats + newSeat, cor) % MOD;
        if(i!=0 && seats==2)
            memo[i][seats] = (memo[i][seats] + help(i+1, newSeat, cor)) % MOD;
        
        return memo[i][seats];
    }
}


//
// class Solution {
//     int MOD = 1_000_000_007;
//     int[][] memo;
    
//     public int numberOfWays(String cor) {
//         memo = new int[cor.length()][3];
//         for(int[] m1: memo) Arrays.fill(m1, -1);
        
//         return help(0, 0, cor);
//     }
//     private int help(int i, int seats, String cor){
//         if(seats==3) return 0;
//         if(i==cor.length()){
//             return seats==2 ? 1 : 0;
//         }
        
//         if(memo[i][seats] != -1) return memo[i][seats];

//         int newSeat = cor.charAt(i)=='S' ? 1 : 0;
//         memo[i][seats] = help(i+1, seats + newSeat, cor)%MOD;
        
//         if(i != 0 && seats==2){
//             memo[i][seats] = (memo[i][seats] + help(i+1, newSeat, cor))%MOD;
//         }
        
//         return memo[i][seats];
//     }
// }