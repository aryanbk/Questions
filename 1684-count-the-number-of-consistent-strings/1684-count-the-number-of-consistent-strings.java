class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] given = getChars(allowed);

        int ans = 0;
        for(String w: words) ans += valid(given, getChars(w));
        return ans;
    }
    
    boolean[] getChars(String s){
        boolean[] ans = new boolean[26];
        for(int i=0; i<s.length(); ++i) ans[s.charAt(i)-'a'] = true;
        return ans;
    }
    
    int valid(boolean[] given, boolean[] cur){
        for(int i=0; i<26; ++i){
            if(cur[i] && !given[i]) return 0;
        }
        return 1;
    }
}