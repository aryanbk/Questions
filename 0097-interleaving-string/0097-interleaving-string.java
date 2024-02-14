class Solution {
    Boolean[][][] cache;
    public boolean isInterleave(String s1, String s2, String s3) {
        cache = new Boolean[s1.length()+1][s2.length()+1][s3.length()+1];
        return solve(0, 0, 0, s1, s2, s3);
    }
    boolean solve(int i, int j, int k, String s1, String s2, String s3){
        if(k==s3.length()) 
            return i==s1.length() && j == s2.length();
        
        if(cache[i][j][k] != null) return cache[i][j][k];
        
        boolean ans = false;
        if(i<s1.length() && s1.charAt(i) == s3.charAt(k)) 
            ans |= solve(i+1, j, k+1, s1, s2, s3);
        if(j<s2.length() && s2.charAt(j) == s3.charAt(k))
            ans |= solve(i, j+1, k+1, s1, s2, s3);
        
        cache[i][j][k] = ans;
        return ans;
    }
}