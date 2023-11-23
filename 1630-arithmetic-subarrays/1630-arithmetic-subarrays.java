// O(m*n)
//
class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int m = l.length;
        List<Boolean> ans = new ArrayList<>();

        for (int i = 0; i < m; ++i) {
            Set<Integer> set = new HashSet<>();
            int mx = Integer.MIN_VALUE;
            int mn = Integer.MAX_VALUE;

            for(int j = l[i]; j <= r[i]; ++j) {
                set.add(nums[j]);
                mx = Math.max(mx, nums[j]);
                mn = Math.min(mn, nums[j]);
            }

            if((mx - mn) % (r[i] - l[i]) != 0) {
                ans.add(false);
                continue;
            }

            int diff = (mx - mn) / (r[i] - l[i]);
            while(set.contains(mn) && mn < mx)
                mn += diff;

            ans.add(mn == mx);
        }

        return ans;
    }
}


// O(m*n log(n))
//
// class Solution {
//     public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
//         int m = l.length;
//         List<Boolean> ans = new ArrayList<>();

//         for (int i = 0; i < m; ++i) {
            
//             int[] subArray = Arrays.copyOfRange(nums, l[i], r[i] + 1);
//             Arrays.sort(subArray);
//             ans.add(isArith(subArray));

//         }

//         return ans;
//     }

//     // Method to check if the given array forms an arithmetic subarray
//     private boolean isArith(int[] arr) {
//         int j = 0;
//         int diff = arr[1] - arr[0];
//         for (; j < arr.length - 1; ++j) {
//             if (arr[j + 1] - arr[j] != diff) {
//                 break;
//             }
//         }
//         return j == arr.length - 1;
//     }
// }



// class Solution {
//     public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
//         int m = l.length;
//         List<Boolean> ans = new ArrayList<>();
        
//         for(int i=0; i<m; ++i){
//             int[] sub = Arrays.copyOfRange(nums, l[i], r[i]+1);
//             Arrays.sort(sub);
            
//             int j = 0;
//             int diff = sub[1] - sub[0];
//             for(; j<r[i]-l[i]; ++j){
//                 if(sub[j+1] - sub[j] != diff){
//                     break;
//                 }
//             }
//             ans.add(j==r[i]-l[i]);
//         }
        
//         return ans;
//     }
// }