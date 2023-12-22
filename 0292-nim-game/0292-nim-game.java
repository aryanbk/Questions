class Solution {
    public boolean canWinNim(int n) {
        return n%4 != 0;
    }
}


// // DP - memo O(n)
// // wont work n is too large
//
// class Solution {
//     Map<Integer, Boolean> memo = new HashMap<>();
//     public boolean canWinNim(int n) {
//         if(n<=3)
//             return true;
        
//         if(memo.containsKey(n))
//             return memo.get(n);
        
//         for(int i=1; i<=3; ++i){
//             if(!canWinNim(n-i)){
//                 memo.put(n, true);
//                 return true;
//             }
//         }
//         memo.put(n, false);
//         return false;
//     }
// }

// // recursive O(3^n)
//
// class Solution {
//     public boolean canWinNim(int n) {
//         if(n<=3)
//             return true;
        
//         for(int i=1; i<=3; ++i){
//             if(!canWinNim(n-i))
//                 return true;
//         }
//         return false;
//     }
// }