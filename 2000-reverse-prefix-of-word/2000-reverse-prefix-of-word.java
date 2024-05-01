class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for(; i<word.length(); ++i){
            sb.append(word.charAt(i));
            if(word.charAt(i) == ch) break;
        }
        if(i==word.length()) return word;
        sb = sb.reverse();
        return sb.toString() + word.substring(i+1);
    }
}