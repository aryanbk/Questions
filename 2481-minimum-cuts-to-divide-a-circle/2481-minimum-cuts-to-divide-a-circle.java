class Solution {
    public int numberOfCuts(int n) {
        if(n%2==0) return n/2;
        return (n!=1) ? n : 0;
    }
}