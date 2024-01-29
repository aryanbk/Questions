class MyQueue {
    Stack<Integer> stk1;
    
    public MyQueue() {
        stk1 = new Stack<>();
    }
    
    public void push(int x) {
        if(stk1.isEmpty()){
            stk1.push(x);
            return;
        }
        int top = stk1.pop();
        push(x);
        stk1.push(top);
        return;
    }
    
    public int pop() {
        return stk1.pop();
    }
    
    public int peek() {
        return stk1.peek();
    }
    
    public boolean empty() {
        return stk1.isEmpty();
    }
}



// // brute force
// //
// class MyQueue {
//     Stack<Integer> stk1;
//     Stack<Integer> stk2;
    
//     public MyQueue() {
//         stk1 = new Stack<>();
//         stk2 = new Stack<>();
//     }
    
//     public void push(int x) {
//         stk1.push(x);
//     }
    
//     public int pop() {
//         while(!stk1.isEmpty())
//             stk2.push(stk1.pop());
        
//         int ans = stk2.pop();
        
//         while(!stk2.isEmpty())
//             stk1.push(stk2.pop());
        
//         return ans;
//     }
    
//     public int peek() {
//         return stk1.get(0);
//     }
    
//     public boolean empty() {
//         return stk1.isEmpty();
//     }
// }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */