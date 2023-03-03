class Solution {
    public int strStr(String hay, String needle) {
        for(int i=0; i<hay.length(); ++i){
            int j=0;
            for(int k=i; j<needle.length() && k<hay.length() && hay.charAt(k)==needle.charAt(j); k++, j++);
            if(j==needle.length()) return i;
        }
        return -1;
    }
}