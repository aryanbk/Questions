class Solution {
    public int passThePillow(int n, int time) {
        int pass = time/(n-1);
        int mod = time%(n-1);
        
        return pass%2==0 ? mod+1 : n-mod;
    }
}