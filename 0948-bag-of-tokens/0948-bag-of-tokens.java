class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int i = 0;
        int j = tokens.length-1;
        int score = 0;
        int ans = 0;
        
        while(i<=j){
            if(tokens[i] <= power){
                power -= tokens[i++];
                ++score;
                ans = score;
            }
            else if(score > 0) {
                power += tokens[j--];
                --score;
            }
            else return ans;
        }
        
        return ans;
    }
}