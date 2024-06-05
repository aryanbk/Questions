class Solution {
    public List<String> commonChars(String[] words) {
        int n = words.length;
        int[][] f = new int[n][26];
        
        for(int i=0; i<words.length; ++i){
            for(int j=0; j<words[i].length(); ++j){
                ++f[i][words[i].charAt(j)-'a'];
            }
        }
        
        int[] minF = new int[26];
        Arrays.fill(minF, 1000000000);
        
        for(int c=0; c<26; ++c){
            for(int i=0; i<words.length; ++i){
                minF[c] = Math.min(minF[c], f[i][c]);
            }
        }
        
        List<String> ans = new ArrayList<>();
        
        for(int i=0; i<26; ++i){
            for(int x=0; x<minF[i]; ++x){
                char ch = (char)(i+'a');
                ans.add(String.valueOf(ch));
            }
        }
        
        return ans;
    }
}