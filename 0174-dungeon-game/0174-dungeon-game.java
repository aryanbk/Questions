class Solution {
    int m;
    int n;
    int[][] memo;
    
    public int calculateMinimumHP(int[][] dungeon) {
        m = dungeon.length;
        n = dungeon[0].length;
        
        memo  = new int[m][n];
        for(int[] row: memo) Arrays.fill(row, -1);
        
        return help(0, 0, dungeon) + 1;
    }
    
    private int help(int i, int j, int[][] dun){
        if(i<0 || i>=m || j<0 || j>=n)
            return 100000000;
        if(i==m-1 && j==n-1)
            return Math.max(dun[i][j]*-1, 0);
        if(memo[i][j] != -1)
            return memo[i][j];
        
        int ans = Math.min(help(i+1, j, dun), help(i, j+1, dun)) + -1*dun[i][j];
        memo[i][j] = Math.max(ans, 0);
        
        return memo[i][j];
    }
}


// class Solution {
//     int m;
//     int n;
//     Map<List<Integer>, Boolean> map;
//     public int calculateMinimumHP(int[][] dungeon) {
//         m = dungeon.length;
//         n = dungeon[0].length;
//         map = new HashMap<>();
        
//         int lo = 1;
//         int hi = 100000000;
//         int res = -1;
//         while(lo<=hi){
//             int mid = lo + (hi-lo)/2;
//             if(isPossible(0, 0, mid, dungeon)){
//                 res = mid;
//                 hi = mid - 1;
//             }else
//                 lo = mid + 1;
//         }
//         return res;
//     }
//     private boolean isPossible(int i, int j, int health, int[][] dun){
//         if(i<0 || i>=m || j<0 || j>=n || health<=0)
//             return false;
//         if(i==m-1 && j==n-1)
//             return health + dun[i][j] > 0;
        
//         List<Integer> key = List.of(i, j, health);
//         if(map.containsKey(key)) return map.get(key);
        
//         health += dun[i][j];
//         map.put(key, isPossible(i+1, j, health, dun) || isPossible(i, j+1, health, dun));
        
//         return map.get(key);
//     }
// }


// // recurssion & binary search - wont work
// // TLE - O(2^(m*n) * log(10^9))
//
// class Solution {
//     int m;
//     int n;
//     public int calculateMinimumHP(int[][] dungeon) {
//         int lo = 1;
//         int hi = 100000000;
//         m = dungeon.length;
//         n = dungeon[0].length;
//         int res = -1;
//         while(lo<=hi){
//             int mid = lo + (hi-lo)/2;
//             if(isPossible(0, 0, mid, dungeon)){
//                 res = mid;
//                 hi = mid - 1;
//             }else
//                 lo = mid + 1;
//         }
//         return res;
//     }
//     private boolean isPossible(int i, int j, int health, int[][] dun){
//         if(i<0 || i>=m || j<0 || j>=n || health<=0)
//             return false;
//         if(i==m-1 && j==n-1)
//             return health + dun[i][j] > 0;
//         health += dun[i][j];
        
//         return isPossible(i+1, j, health, dun) || isPossible(i, j+1, health, dun);
//     }
// }


// // wont work
// // wrong approch
//
//
// class Solution {
//     int mn = 1000000;
//     int m;
//     int n;
    
//     public int calculateMinimumHP(int[][] dungeon) {
//         m = dungeon.length;
//         n = dungeon[0].length;
//         go(m-1, n-1, dungeon);
//         return mn;
//         // return (mn);
//     }
//     private int go(int i, int j, int[][] dun){
//         if(i<0 || i>=m || j<0 || j>=n)
//             return -1000000;
//         if(i==0 && j==0){
//             mn = Math.min(mn, dun[i][j]);
//             return dun[i][j];
//         }
        
//         int ans = Math.max(go(i-1, j, dun), go(i, j-1, dun)) + dun[i][j];
//         mn = Math.min(mn, ans);
//         // mn = Math.min(mn, dun[i][j]);
//         return ans;
//     }
// }