class Solution {
    public int minimumPushes(String word) {
        int ans = 0;
        int[] freq = new int[26];
        
        for(int i=0; i<word.length(); ++i)
            ++freq[word.charAt(i)-'a'];
        
        Arrays.sort(freq);
        for(int i=freq.length-1; i>=0; --i){
            int assigned = 25 - i;
            ans += (assigned/8 + 1) * freq[i];
        }
        
        return ans;
    }
}