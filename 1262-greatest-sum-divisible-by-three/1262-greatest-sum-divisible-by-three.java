class Solution {
    int[][] memo;
    public int maxSumDivThree(int[] nums) {
        memo = new int[nums.length+1][3];
        for(int[] row: memo) Arrays.fill(row, -1);
        return help(nums.length, 0,nums);
    }
    private int help(int i, int remainder, int[] nums){
        if(i==0)
            return remainder==0 ? 0 : -100000000;
        
        if(memo[i][remainder] != -1) return memo[i][remainder];
        
        memo[i][remainder] = Math.max(help(i-1, remainder, nums), 
                                      nums[i-1]+help(i-1, (remainder+nums[i-1])%3, nums));
        return memo[i][remainder];
    }
}


// // memo 
// // O(n*sumt(n))
// // TLE, MLE
// //
// class Solution {
//     Map<List<Integer>, Integer> map;
//     public int maxSumDivThree(int[] nums) {
//         map = new HashMap<>();
//         return help(nums.length, 0,nums);
//     }
//     private int help(int i, int sumt, int[] nums){
//         if(i==0)
//             return sumt%3==0 ? sumt : 0;
//         List<Integer> list = List.of(i, sumt);
//         if(map.containsKey(list)) return map.get(list);
        
//         map.put(list, Math.max(help(i-1, sumt, nums), help(i-1, sumt+nums[i-1], nums)));
//         return map.get(list);
//     }
// }

// // recursion O(2^n) TLE
//
// class Solution {
//     public int maxSumDivThree(int[] nums) {
//         return help(nums.length, 0,nums);
//     }
//     private int help(int i, int sumt, int[] nums){
//         if(i==0)
//             return sumt%3==0 ? sumt : 0;
//         return Math.max(help(i-1, sumt, nums), help(i-1, sumt+nums[i-1], nums));
//     }
// }