class Solution {
    boolean[][] memo;
    public boolean canPartition(int[] nums) {
        int target=0;
        for(int n:nums){
            target += n;
        }
        if(target%2==1){
            return false;
        }
        target /= 2;
        memo = new boolean[target+1][nums.length];
        for(int t=0; t<=target; ++t){
            for(int ptr=0; ptr<nums.length; ++ptr){
                if(t==0){
                    memo[t][ptr]=true;
                }else if(ptr==0){
                    memo[t][ptr]=false;
                }else{
                    memo[t][ptr]=memo[t][ptr-1];
                    if(t>=nums[ptr] && !memo[t][ptr]){
                        memo[t][ptr] = memo[t-nums[ptr]][ptr-1];
                    }
                }
            }
        }
        return memo[target][nums.length-1];
    }
}


// class Solution {
//     int[][] memo;
//     public boolean canPartition(int[] nums) {
//         int target=0;
//         for(int n:nums){
//             target += n;
//         }
//         if(target%2==1){
//             return false;
//         }
//         target /= 2;
//         memo = new int[target+1][nums.length+1];
//         return knap(0, nums, target);
//     }
//     boolean knap(int ptr, int[] nums, int target){
//         if(target==0){
//             return true;
//         }else if(ptr>=nums.length || target<0){
//             return false;
//         }else if(memo[target][ptr] != 0){
//             return memo[target][ptr]==1 ? true : false; 
//         }else{
//             boolean res = knap(ptr+1, nums, target) || knap(ptr+1, nums, target-nums[ptr]);
//             memo[target][ptr] = (res) ? 1 : -1;
//             return res;
//         }
//     }
// }

// class Solution {
//     public boolean canPartition(int[] nums) {
//         int sumt=0;
//         for(int n:nums){
//             sumt+=n;
//         }
//         int target=sumt/2;
//         return knap(0, nums, target);
//     }
//     boolean knap(int ptr, int[] nums, int target){
//         if(target==0){
//             return true;
//         }else if(ptr>=nums.length || target<0){
//             return false;
//         }else{
//             return knap(ptr+1, nums, target) || knap(ptr+1, nums, target-nums[ptr]);
//         }
//     }
// }