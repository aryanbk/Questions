class MinStack {
    
    Stack<Integer> stk;
    Stack<Integer> ms;
    
    public MinStack() {
        stk = new Stack<>();
        ms = new Stack<>();
    }
    
    public void push(int val) {
        stk.push(val);
        if(ms.isEmpty() || val <= ms.peek())
            ms.push(val);
    }
    
    public void pop() {
        int popped = stk.pop();
        if (popped == ms.peek())
            ms.pop();
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return ms.peek();
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