class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder reversed = new StringBuilder(s).reverse();
        String s2 = reversed.toString();
        return longestCommonSubsequence(s, s2);
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