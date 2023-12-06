class Solution {
    Map<List<Integer>, Integer> memo;
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        memo = new HashMap<>();
        return mcm(0, n, cuts);
    }
    private int mcm(int i, int j, int[] cuts){
        if(i>=j-1) return 0;
        
        List<Integer> list = List.of(i, j);
        if(memo.containsKey(list)) return memo.get(list); 
        
        int ans = 10000000;
        for(int k=0; k<cuts.length; ++k){
            if(i<cuts[k] && cuts[k]<j)
            ans = Math.min(ans, j-i + mcm(i, cuts[k], cuts) + mcm(cuts[k], j, cuts));
        }
        memo.put(list, ans==10000000 ? 0 : ans);
        return memo.get(list);
    }
}


// // memo dp from i=0 to j=n
// // it will give memory limit exceeded
// // https://leetcode.com/submissions/detail/1113431414/
// //
// class Solution {
//     int[][] memo;
//     public int minCost(int n, int[] cuts) {
//         Arrays.sort(cuts);
//         memo = new int[n+1][n+1];
//         for(int[] row: memo) Arrays.fill(row, -1);
//         return mcm(0, n, cuts);
//     }
//     private int mcm(int i, int j, int[] cuts){
//         if(i>=j-1) return 0;
        
//         if(memo[i][j] != -1) return memo[i][j]; 
        
//         int ans = 10000000;
//         for(int k=0; k<cuts.length; ++k){
//             if(i<cuts[k] && cuts[k]<j)
//             ans = Math.min(ans, j-i + mcm(i, cuts[k], cuts) + mcm(cuts[k], j, cuts));
//         }
//         memo[i][j] = ans==10000000 ? 0 : ans;
//         return memo[i][j];
//     }
// }


// // recursive i=0 to j=n
// // 
// class Solution {
//     public int minCost(int n, int[] cuts) {
//         Arrays.sort(cuts);
//         return mcm(0, n, cuts);
//     }
//     private int mcm(int i, int j, int[] cuts){
//         if(i>=j-1) return 0;
        
//         int ans = 10000000;
//         for(int k=0; k<cuts.length; ++k){
//             if(i<cuts[k] && cuts[k]<j)
//             ans = Math.min(ans, j-i + mcm(i, cuts[k], cuts) + mcm(cuts[k], j, cuts));
//         }
//         return ans==10000000 ? 0 : ans;
//     }
// }