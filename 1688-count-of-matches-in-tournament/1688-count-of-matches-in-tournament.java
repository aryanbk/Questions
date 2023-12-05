class Solution {
    public int numberOfMatches(int n) {
        int match = 0;
        while(n!=1){
            match += n/2;
            if((n&1)==1) n = (n/2) +1;
            else n= n/2;
        }
        return match;
    }
}