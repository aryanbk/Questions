class Solution {
    int target;
    int n;
    boolean[] vis;
    
    public boolean canPartitionKSubsets(int[] nums, int k) {
        n = nums.length;
        vis = new boolean[n];
        int sumt = 0;
        for(int n: nums) sumt += n;
        
        if(sumt%k != 0) return false;
        
        target = sumt/k;
        return bk(0, 0, k, nums);
    }
    
    private boolean bk(int i, int sumt, int k, int[] nums){
        if(k==0)
            return true;
        if(sumt == target)
            return bk(0, 0, k-1, nums);
        
        for(int x=i; x<n; ++x){
            if(!vis[x] && sumt + nums[x] <= target){
                vis[x] = true;
                if(bk(x+1, sumt + nums[x], k, nums)){
                    return true;
                }
                vis[x] = false;
            }
        }
        return false;
    }
}


// // failed attempts
//
// class Solution {
//     public boolean canPartitionKSubsets(int[] nums, int k) {
//         int sumt = 0;
//         for(int n: nums) sumt += n;
//         return sumt%k==0 ? subsetsum(nums, sumt/k) : false;
//     }
//     private boolean canPart(int i, int k, int[] nums, int vis, int sumt){
//         if(i==nums.length)
//             return k==1;
        
//     }
// }


// // // works but give TLE
// //
// // class Solution {
// //     public boolean canPartitionKSubsets(int[] nums, int k) {
// //         return bkt(0, new int[k], nums);
// //     }
// //     private boolean bkt(int i, int[] k, int[] nums){
// //         if(i==nums.length){
// //             for(int x=1; x<k.length; ++x){
// //                 if(k[x] != k[0]) return false;
// //             }
// //             return true;
// //         }
// //         boolean ans = false;
// //         for(int x=0; x<k.length; ++x){
// //             k[x] += nums[i];
// //             ans |= bkt(i+1, k, nums);
// //             k[x] -= nums[i];
// //         }
// //         return ans;
// //     }
// // }


// // // this wont work - will give WA
// //
// // class Solution {
// //     public boolean canPartitionKSubsets(int[] nums, int k) {
// //         int sumt = 0;
// //         for(int n: nums) sumt += n;
// //         return sumt%k==0 ? subsetsum(nums, sumt/k) : false;
// //     }
// //     private boolean subsetsum(int[] nums, int trgt){
// //         int lngt = nums.length;
// //         boolean dp[][] = new boolean[lngt+1][trgt+1];
// //         for(int l=0; l<=lngt; ++l){
// //             for(int t=0; t<=trgt; ++t){
// //                 if(t==0) dp[l][t] = true;
// //                 else if(l!=0)
// //                     dp[l][t] = t>=nums[l-1] ? dp[l-1][t] || dp[l-1][t-nums[l-1]] : dp[l-1][t];
// //             }
// //         }
// //         return dp[lngt][trgt];
// //     }
// // }