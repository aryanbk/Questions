class Solution {
    // int[] freq;
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] freq = new int[26];
        for(char ch: letters) ++freq[ch-'a'];
        return solve(0, words, score, freq);
    }
    
    int solve(int i, String[] words, int[] score, int[] freq){
        if(i == words.length) return 0;
        // if(!valid(words[i])) return solve(i+1, words, score);
        int[] freq2 = Arrays.copyOf(freq, 26);
        int curScore = 0;
        
        for(int x=0; x<words[i].length(); ++x){
            int cc = words[i].charAt(x)-'a';
            if(freq2[cc] > 0){
                --freq2[cc];
                curScore += score[cc];
            }
            else return solve(i+1, words, score, freq);
        }
        
        int left = solve(i+1, words, score, freq);
        int right = solve(i+1, words, score, freq2) + curScore;
        int ans = Math.max(left, right);
        // System.out.println(Arrays.toString(freq2));
        // System.out.println(i+" "+curScore+" "+ans+" "+left+" "+right);
        return ans;
    }
}