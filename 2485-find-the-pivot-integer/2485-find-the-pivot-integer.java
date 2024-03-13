class Solution {
    public int pivotInteger(int n) {
        double ans = Math.sqrt(n*(n+1)/2);
        return Math.floor(ans) == ans ? (int)ans : -1;
    }
}