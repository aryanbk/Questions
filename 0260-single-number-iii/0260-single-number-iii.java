class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int n: nums) xor ^= n;
        
        int last = xor & -xor;
        int[] ans = {0, 0};
        
        for(int n: nums){
            if((last & n) == last) ans[0] ^= n;
            else ans[1] ^= n;
        }
        
        return ans;
    }
}



// class Solution {
//     public int[] singleNumber(int[] nums) {
//         int xor = 0;
//         int and = 0;
//         int or = 0;
//         for(int n: nums){
//             xor ^= n;
//             and &= n;
//             or |= n;
//         }
//         int[] ans = new int[2];
//         while(!(xor==0 && and==0 && or==0)){
//             if((and&1)==1){
//                 ans[0] += 1;
//                 ans[1] += 1;
//             }
//             else if((and&1)==0 && (or&1)==1){
//                 ans
//             }
//         }
//     }
// }