class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        for(int i=1; i<4; ++i){
            int e = arr[(i*n)/4];
            if((last(arr, e) - first(arr, e) + 1)*4 > n)
                return e;
        }
        return -1;
    }
    private int first(int[] arr, int x){
        int lo = 0;
        int hi = arr.length - 1;
        int res = -1;
        
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(arr[mid] >= x){
                res = mid;
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        return res;
    }
    private int last(int[] arr, int x){
        int lo = 0;
        int hi = arr.length - 1;
        int res = -1;
        
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(arr[mid] > x){
                hi = mid - 1;
            }else{
                res = mid;
                lo = mid + 1;
            }
        }
        return res;
    }
}



// class Solution {
//     public int findSpecialInteger(int[] arr) {
//         int n = arr.length;
//         for(int i=1; i<4; ++i){
//             int e = arr[(i*n)/4];
//             if((last(arr, e) - first(arr, e) + 1)*4 > n)
//                 return e;
//         }
//         return -1;
//     }
//     private int first(int[] arr, int x){
//         int lo = 0;
//         int hi = arr.length - 1;
//         int res = -1;
        
//         while(lo <= hi){
//             int mid = lo + (hi - lo)/2;
//             if(arr[mid] == x){
//                 res = mid;
//                 hi = mid - 1;
//             }
//             else if(arr[mid] > x){
//                 hi = mid - 1;
//             }else{
//                 lo = mid + 1;
//             }
//         }
//         return res;
//     }
//     private int last(int[] arr, int x){
//         int lo = 0;
//         int hi = arr.length - 1;
//         int res = -1;
        
//         while(lo <= hi){
//             int mid = lo + (hi - lo)/2;
//             if(arr[mid] == x){
//                 res = mid;
//                 lo = mid + 1;
//             }
//             else if(arr[mid] > x){
//                 hi = mid - 1;
//             }else{
//                 lo = mid + 1;
//             }
//         }
//         return res;
//     }
// }

// class Solution {
//     public int findSpecialInteger(int[] arr) {
//         int num = -1;
//         int count = 0;
//         for(int i = 0; i<arr.length; ++i){
//             if(arr[i] != num){
//                 num = arr[i];
//                 count = 0;
//             }
//             count += 1;
//             if(count*4 > arr.length)
//                 return num;
//         }
//         return -1;
//     }
// }