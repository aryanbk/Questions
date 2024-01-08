class MinStack {
    
    Stack<Integer> stk;
    Stack<Integer> mnstk;
    
    public MinStack() {
        stk = new Stack<>();
        mnstk = new Stack<>();
    }
    
    public void push(int val) {
        stk.push(val);
        if(mnstk.isEmpty() || val <= mnstk.peek())
            mnstk.push(val);
    }
    
    public void pop() {
        int popped = stk.pop();
        if (popped == mnstk.peek())
            mnstk.pop();
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return mnstk.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */