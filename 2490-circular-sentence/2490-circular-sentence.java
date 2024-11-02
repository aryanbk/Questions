class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] sen = sentence.split(" ");
        int n = sen.length;
        for(int i=0; i<n; ++i){
            String cur = sen[i];
            String nx = sen[(i+1)%n];
            if(cur.charAt(cur.length()-1) != nx.charAt(0)) return false;
        }
        return true;
    }
}