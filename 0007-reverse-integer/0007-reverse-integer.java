class Solution {
    public int reverse(int x) {
        long ans=0;
        while(x != 0){
            ans = (ans*10) + (x%10);
            x/=10;
        }
        int res = (int)ans;
        return res==ans ? res : 0;
        // return (ans<=Integer.MAX_VALUE && ans>=Integer.MIN_VALUE) ? (int)ans : 0;
        
    }
}