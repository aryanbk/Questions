// DP

// class Solution {
//     int or;
//     Map<List<Integer>, Integer> dp;
//     public int countMaxOrSubsets(int[] nums) {
//         or = 0;
//         dp = new HashMap<>();
//         for(int num: nums) or |= num;
//         return solve(0, 0, nums);
//     }
    
//     int solve(int i, int cur, int[] nums){
//         if(i==nums.length) return cur==or ? 1 : 0;
//         var list = new ArrayList<Integer>();
//         list.add(i);
//         list.add(cur);
//         if(dp.containsKey(list)) return dp.get(list);
//         int ans = solve(i+1, cur, nums) + solve(i+1, cur|nums[i], nums);
//         dp.put(list, ans);
//         return ans;
//     }
// }


// recursion

class Solution {
    int or;
    public int countMaxOrSubsets(int[] nums) {
        or = 0;
        for(int num: nums) or |= num;
        return solve(0, 0, nums);
    }
    
    int solve(int i, int cur, int[] nums){
        if(i==nums.length) return cur==or ? 1 : 0;
        return solve(i+1, cur, nums) + solve(i+1, cur|nums[i], nums);
    }
}