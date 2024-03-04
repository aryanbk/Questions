class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int i = 0;
        int j = tokens.length-1;
        int curScore = 0;
        int mxScore = 0;
        
        while(i<=j){
            if(tokens[i] <= power){
                power -= tokens[i++];
                ++curScore;
                mxScore = curScore;
            }
            else if(curScore > 0) {
                power += tokens[j--];
                --curScore;
            }
            else return mxScore;
        }
        
        return mxScore;
    }
}