class Solution {
    public int totalMoney(int n) {
        int ans = 0;
        int x = 1;
        while(n>0){
            int day = 0;
            while(n>0 && day<7){
                ans += day + x;
                day++;
                n--;
            }
            x++;
        }
        return ans;
    }
}