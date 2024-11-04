class Solution {
    public String compressedString(String word) {
        StringBuilder ans = new StringBuilder();
        
        for(int i=0; i<word.length();){
            char c = word.charAt(i);
            int j = i;
            while(i<word.length() && c == word.charAt(i) && i-j<=8) ++i;
            ans.append(Integer.toString(i-j));
            ans.append(c);
        }
        
        return ans.toString();
    }
}