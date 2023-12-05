class Solution {
    int[][] map;
    
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        // System.out.println(Arrays.toString(words));
        int n = words.length;
        map = new int[n][26];
        for(int w=0; w<words.length; ++w){
            for(int i=0; i<words[w].length(); ++i)
                map[w][i]++;
        }
        return lengthOfLIS(words);
    }
    public int lengthOfLIS(String[] nums) {
        int n = nums.length;
        int[]dp = new int[n];
        Arrays.fill(dp, 1);
        int ans = 1;
        
        for(int i=0; i<n; ++i){
            for(int j=0; j<i; ++j){
                if(isValid(i, j, nums)) dp[i] = Math.max(dp[i], dp[j]+1);
            }
            ans = Math.max(ans, dp[i]);
        }
        
        return ans;
    }
    private boolean isValid(int i, int j, String[] words){
        if(words[i].length() != words[j].length()+1) return false;
        int diff = 0;
        for(int x=0, y=0; x<words[i].length() && y<words[j].length(); ++x, ++y){
            if(words[i].charAt(x) != words[j].charAt(y)){
                if(diff==1) return false;
                diff++;
                y--;
            }
        }
        return true;
    }
}