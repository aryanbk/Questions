class Solution {
    public int strStr(String hay, String needle) {
        for(int i=0; i<=hay.length()-needle.length(); ++i){
            if(hay.substring(i, i+needle.length()).equals(needle)) return i;
        }
        return -1;
    }
}