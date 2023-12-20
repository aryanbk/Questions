class Solution {
    public int buyChoco(int[] prices, int money) {
        int a = 101;
        int b = 101;
        for(int p: prices){
            if(p<a || p<b){
                a = Math.min(a, b);
                b = p;
            }
        }
        return money-a-b<0 ? money : money-a-b;
    }
}