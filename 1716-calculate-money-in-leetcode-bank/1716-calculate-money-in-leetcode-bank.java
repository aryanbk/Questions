class Solution {
    public int totalMoney(int n) {
        int ans = 0;
        int monday = 1;
        while(n>0){
            for(int day=0; day<7 && n>0; ++day, --n)
                ans += day + monday;
            ++monday;
        }
        return ans;
    }
}