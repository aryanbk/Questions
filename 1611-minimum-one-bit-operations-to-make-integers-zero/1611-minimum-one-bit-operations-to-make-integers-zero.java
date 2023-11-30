class Solution {
    public int minimumOneBitOperations(int n) {
        if(n==0) return 0;
        int mostSig = 0; //most significant bit position
        int num = 1; // Math.pow(2, mostSig)
        while(num<=n){
            num *= 2;
            mostSig++;
        }
        mostSig--;
        num/=2;
        return (num*2) - 1 + - minimumOneBitOperations(num ^ n);
    }
}

// ref (neetcode) - https://www.youtube.com/watch?v=yRI18_MaG7k

// first attempt
//
// class Solution {
//     public int minimumOneBitOperations(int n) {
//         return help(n);
//     }
//     private int help(int n){
//         if(n<2) return n;
//         int mostSig = 0;
//         int num = 1;
//         while(num<=n){
//             num *= 2;
//             mostSig++;
//         }
//         mostSig--;
//         // num /= 2;
//         // System.out.println(n+" "+num+" "+mostSig);
//         return num - 1 + - help((num/2) ^ n);
//     }
// }