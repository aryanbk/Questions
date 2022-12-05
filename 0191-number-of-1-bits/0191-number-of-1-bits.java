// while(n>0) wont work

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans=0;
        while(n != 0){
            ans += 1;
            n &= (n-1);
        }
        return ans;
        
        // this wont work while(n>0)
        //
        // int ans=0;
        // while(n > 0){
        //     ans+=1;
        //     n = n&(n-1);
        // }
        // return ans;
    }
}


// public class Solution {
//     // you need to treat n as an unsigned value
//     public int hammingWeight(int n) {
//         int ans =0, mask=1;
//         for(int i=0; i<32 ; ++i){
//             if((n & mask) !=0 ) ans+=1;
//             mask = mask<<1;
//         }
//         return ans;

//         // this wont work while(n>0)
//         //
//         // int ans=0;
//         // while(n>0){
//         //     ans += n%2;
//         //     n = n>>1;
//         // }
//         // return ans;
//     }
// }