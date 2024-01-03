class Solution {
    public int minimizeSet(int d1, int d2, int u1, int u2) {
        int ans = -1;
        long lo = 2;
        long hi = Integer.MAX_VALUE;
        
        while(lo <= hi){
            long mid = lo + (hi-lo)/2;
            boolean res = check((int)mid, d1, d2, u1, u2);
            if(res){
                ans = (int)mid;
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        
        return ans;
        
    }
    
    boolean check(long num, long d1, long d2, long u1, long u2){
        long a = num - (num/d1);
        long b = num - (num/d2);
        long c = num - (num/d1) - (num/d2) + (num/lcm(d1, d2));
        
        return a>=u1 && b>=u2 && (a+b-c >= u1+u2);
    }
    
    private long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }
}


// // WA #3
// //
// class Solution {
//     public int minimizeSet(int d1, int d2, int u1, int u2) {
//         int ans = -1;
//         long lo = 2;
//         long hi = 1000000001; // WA #3
        
//         while(lo <= hi){
//             long mid = lo + (hi-lo)/2;
//             boolean res = check((int)mid, d1, d2, u1, u2);
//             if(res){
//                 ans = (int)mid;
//                 hi = mid - 1;
//             }else{
//                 lo = mid + 1;
//             }
//         }
        
//         return ans;
        
//     }
    
//     boolean check(long num, long d1, long d2, long u1, long u2){
//         long a = num - (num/d1);
//         long b = num - (num/d2);
//         long c = num - (num/d1) - (num/d2) + (num/lcm(d1, d2));
        
//         return a>=u1 && b>=u2 && (a+b-c >= u1+u2);
//     }

    
//     private long gcd(long a, long b) {
//         if (b == 0) {
//             return a;
//         }
//         return gcd(b, a % b);
//     }

//     public long lcm(long a, long b) {
//         return (a * b) / gcd(a, b);
//     }
// }




// // WA #2
// //
// class Solution {
//     public int minimizeSet(int d1, int d2, int u1, int u2) {
//         int ans = -1;
//         long lo = 2;
//         long hi = Integer.MAX_VALUE;
        
//         while(lo <= hi){
//             long mid = lo + (hi-lo)/2;
//             boolean res = check((int)mid, d1, d2, u1, u2);
//             if(res){
//                 ans = (int)mid;
//                 hi = mid - 1;
//             }else{
//                 lo = mid + 1;
//             }
//         }
        
//         return ans;
        
//     }
    
//     boolean check(long num, long d1, long d2, long u1, long u2){
//         long a = ((d1 - 1) * num + (d1 - 1)) / d1; //wrong
//         long b = ((d2 - 1) * num + (d2 - 1)) / d2; //wrong
//         long d3 = lcm(d1, d2);
//         long c = num/d1 + num/d2 - num/d3;
        
//         if(d1 == d2)
//             return a >= u1 && b >= u2 && (num-(num/d1)) >= (u1 + u2);
        
//         return a >= u1 && b >= u2 && (num - c + (num/d1) + (num/d2)) >= (u1 + u2);
//     }

    
//     private long gcd(long a, long b) {
//         if (b == 0) {
//             return a;
//         }
//         return gcd(b, a % b);
//     }

//     public long lcm(long a, long b) {
//         return (a * b) / gcd(a, b);
//     }
// }



// // WA #1
// //
// class Solution {
//     public int minimizeSet(int d1, int d2, int u1, int u2) {
//         int ans = -1;
//         long lo = 2;
//         long hi = Integer.MAX_VALUE;
        
//         while(lo <= hi){
//             long mid = lo + (hi-lo)/2;
//             boolean res = check((int)mid, d1, d2, u1, u2);
//             if(res){
//                 ans = (int)mid;
//                 hi = mid - 1;
//             }else{
//                 lo = mid + 1;
//             }
//         }
        
//         return ans;
        
//     }
    
//     boolean check(long num, long d1, long d2, long u1, long u2){
//         long a = ((d1 - 1) * num + (d1 - 1)) / d1;
//         long b = ((d2 - 1) * num + (d2 - 1)) / d2;
//         long d3 = lcm(d1, d2);
//         long c = num/d1 + num/d2 - num/d3;
        
//         return a >= u1 && b >= u2 && (num-c+(num/d2)+(num/d1)) >= (u1 + u2);
//     }
//     // if d1 == d2 WA #1

    
//     private long gcd(long a, long b) {
//         if (b == 0) {
//             return a;
//         }
//         return gcd(b, a % b);
//     }

//     public long lcm(long a, long b) {
//         return (a * b) / gcd(a, b);
//     }
// }