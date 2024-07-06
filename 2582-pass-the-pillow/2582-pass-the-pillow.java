class Solution {
    public int passThePillow(int n, int time) {
        int pass = time/(n-1);
        int mod = time%(n-1);
        if(pass%2==0){
            return mod+1;
        }
        else{
            return n-mod;
        }
    }
}