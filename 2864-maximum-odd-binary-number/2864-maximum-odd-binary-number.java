class Solution {
    public String maximumOddBinaryNumber(String s) {
        int n = s.length();
        int one = 0;
        for(int i=0; i<n; ++i) one += s.charAt(i)=='1' ? 1 : 0;
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<one-1; ++i) ans.append('1');
        for(int i=0; i<n-one; ++i) ans.append('0');
        ans.append('1');
        return ans.toString();
    }
}