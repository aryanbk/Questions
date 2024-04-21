class MyStack {
    Queue<Integer> fst;
    Queue<Integer> sec;
    
    public MyStack() {
        fst = new LinkedList<>();
        sec = new LinkedList<>();
    }
    
    public void push(int x) {
        if(fst.isEmpty()) sec.offer(x);
        else fst.offer(x);
    }
    
    public int pop() {
        if(fst.isEmpty()){
            while(sec.size()>1)
                fst.offer(sec.poll());
            return sec.poll();
        }
        else{
            while(fst.size()>1)
                sec.offer(fst.poll());
            return fst.poll();
        }
    }
    
    public int top() {
        if(fst.isEmpty()){
            while(sec.size()>1)
                fst.offer(sec.poll());
            int ans = sec.poll();
            fst.offer(ans);
            return ans;
        }
        else{
            while(fst.size()>1)
                sec.offer(fst.poll());
            int ans = fst.poll();
            sec.offer(ans);
            return ans;
        }
    }
    
    public boolean empty() {
        return fst.isEmpty() && sec.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */