// most optimized (Follow-up)
// amortized O(1)
//
class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;
    
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        peek();
        return out.pop();
    }
    
    public int peek() {
        if(out.isEmpty()){
            while(!in.isEmpty())
                out.push(in.pop());
        }
        return out.peek();
    }
    
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}




// // using only one stack (recursion)
//
// class MyQueue {
//     Stack<Integer> in;
    
//     public MyQueue() {
//         in = new Stack<>();
//     }
    
//     public void push(int x) {
//         if(in.isEmpty()){
//             in.push(x);
//             return;
//         }
//         int top = in.pop();
//         push(x);
//         in.push(top);
//         return;
//     }
    
//     public int pop() {
//         return in.pop();
//     }
    
//     public int peek() {
//         return in.peek();
//     }
    
//     public boolean empty() {
//         return in.isEmpty();
//     }
// }



// // brute force
// //
// class MyQueue {
//     Stack<Integer> in;
//     Stack<Integer> out;
    
//     public MyQueue() {
//         in = new Stack<>();
//         out = new Stack<>();
//     }
    
//     public void push(int x) {
//         in.push(x);
//     }
    
//     public int pop() {
//         while(!in.isEmpty())
//             out.push(in.pop());
        
//         int ans = out.pop();
        
//         while(!out.isEmpty())
//             in.push(out.pop());
        
//         return ans;
//     }
    
//     public int peek() {
//         return in.get(0);
//     }
    
//     public boolean empty() {
//         return in.isEmpty();
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