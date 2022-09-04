class StockSpanner {
    Stack<int[]> stk;
    public StockSpanner() {
        stk=new Stack<>();
    }
    
    public int next(int price) {
        int ans=1;
        while(!stk.isEmpty() && stk.peek()[0]<=price)
            ans += stk.pop()[1];
        stk.push(new int[]{price, ans});
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */