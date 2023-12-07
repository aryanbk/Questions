class Solution {
    public int climbStairs(int n) {
        return climb(n, new Integer[n+1]);
    }
    private int climb(int n, Integer[] memo){
        if(n < 0) return 0;
        if(n == 0) return 1;
        if(memo[n] != null) return memo[n];
        memo[n] = climb(n-1, memo) + climb(n-2, memo);
        return memo[n];
    }
}


// class Solution {
//     public int climbStairs(int n) {
//         return climb(n);
//     }
//     private int climb(int n){
//         if(n < 0) return 0;
//         if(n == 0) return 1;
//         return climb(n-1) + climb(n-2);
//     }
// }