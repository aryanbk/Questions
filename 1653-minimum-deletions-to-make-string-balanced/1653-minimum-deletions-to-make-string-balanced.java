class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int[] aSuff = new int[n+1];
        for(int i=n-1; i>=0; --i)
            aSuff[i] = aSuff[i+1] + (s.charAt(i)=='a' ? 1 : 0);
        int as = aSuff[0];
        int bs = n - as;
        
        if(as == n || as == 0) return 0;
        
        int bPre = 0;
        int ans = Math.min(as, bs);
        
        for(int i=0; i<n; ++i){
            bPre += s.charAt(i)=='b' ? 1 : 0;
            ans = Math.min(ans, bPre + aSuff[i+1]);
        }
        
        return ans;
    }
}







// class Solution {
//     public int minimumDeletions(String s) {
//         int n = s.length();
//         int[] aSuff = new int[n+1];
//         for(int i=n-1; i>=0; --i)
//             aSuff[i] = aSuff[i+1] + (s.charAt(i)=='a' ? 1 : 0);
//         // System.out.println(Arrays.toString(aSuff)+" "+n);
//         int as = aSuff[0];
//         int bs = n - as;
        
//         if(as == n || as == 0) return 0;

//         int bPre = 0;
//         int ans = 1000000000;
        
//         for(int i=0; i<n; ++i){
//             bPre += s.charAt(i)=='b' ? 1 : 0;
//             if(aSuff[i+1]==as || bPre==bs)
//                 ans = Math.min(ans, Math.min(as, bs));
//             else
//                 ans = Math.min(ans, bPre + aSuff[i+1]);
//             // System.out.println(ans);
//         }
        
//         return ans;
//     }
// }