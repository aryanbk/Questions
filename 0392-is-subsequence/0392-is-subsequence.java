// using LCS
// TC - O(m * n)
// SC - O(m)
class Solution {
    public boolean isSubsequence(String s, String t) {
        return longestCommonSubsequence(s, t) == s.length();
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[] t = new int[n+1];
        
        for(int l1=1; l1<=m; ++l1){
            int[] temp = new int[n+1];
            for(int l2=1; l2<=n; ++l2){
                temp[l2] = text1.charAt(l1-1)==text2.charAt(l2-1) ? 1+t[l2-1] :
                Math.max(temp[l2-1], t[l2]);
            }
            t = temp;
        }
        
        return t[n];
    }
}

// TC - O(m + n)
// SC - O(1)
//
// class Solution {
//     public boolean isSubsequence(String s, String t) {
//         if(s.length()==0) return true;
//         int ptrS=0,ptrT=0,sl=s.length(),tl=t.length();
//         while(ptrS<sl && ptrT<tl){
//             if(s.charAt(ptrS)==t.charAt(ptrT)) ptrS++;
//             ptrT++;
//         }
//         return ptrS==sl;
//     }
// }

// class Solution {
//     public boolean isSubsequence(String s, String t) {
//         for(int i=0,l=s.length(), last=-1 ; i<l; i++){
//             int curr=t.indexOf(s.charAt(i));
//             if(curr==-1 || curr<=last) return false;
//             last=curr;
//         }
//         return true;
//     }
// }