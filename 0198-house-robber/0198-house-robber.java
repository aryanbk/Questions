class Solution {
    public int rob(int[] nums) {
        int last=0,secLast=0;
        for(int i: nums){
            int temp=Math.max(i+secLast, last);
            secLast=last;
            last=temp;
        }
        return last;
    }
}




// // wont work
// // testcase [2,1,1,2]
//
// class Solution {
//     public int rob(int[] nums) {
//         int last=0,secLast=0;
//         for(int i: nums){
//             secLast += i;
//             int swap = last;
//             last = secLast;
//             secLast = swap;
//         }
//         return Math.max(last, secLast);
//     }
// }
