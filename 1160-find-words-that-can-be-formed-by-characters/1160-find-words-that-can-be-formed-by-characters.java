class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] freq =  new int[26];
        for(int i=0; i<chars.length(); ++i) freq[chars.charAt(i)-'a']++;
        int ans=0;
        
        for(String s: words){
            if(canMake(s, freq)) ans+=s.length();
        }
        
        return ans;
    }
    
    private boolean canMake(String s, int[] freq){
        int[] sFreq = new int[26];
        for(int i=0; i<s.length(); ++i) sFreq[s.charAt(i)-'a']++;
        
        for(int i=0; i<26; ++i)
            if(freq[i] < sFreq[i]) return false;
        return true;
    }
}