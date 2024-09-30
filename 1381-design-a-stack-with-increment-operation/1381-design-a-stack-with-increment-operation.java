class CustomStack {
    Stack<Integer> stk;
    int n;
    int[] inc;
    
    public CustomStack(int maxSize) {
        stk = new Stack<>();
        n = maxSize;
        inc = new int[n+1];
    }
    
    public void push(int x) {
        if(stk.size() < n) stk.push(x);
    }
    
    public int pop() {
        if(stk.size() == 0) return -1;
        int curInc = inc[stk.size()];
        inc[stk.size()] = 0;
        inc[stk.size()-1] += curInc;
        return stk.pop() + curInc;
    }
    
    public void increment(int k, int val) {
        inc[Math.min(k, stk.size())] += val;
    }
}



// class CustomStack {
//     List<Integer> list;
//     int mxSize;
    
//     public CustomStack(int maxSize) {
//         list = new ArrayList<>();
//         mxSize = maxSize;
//     }
    
//     public void push(int x) {
//         if(list.size() < mxSize) list.add(x);
//     }
    
//     public int pop() {
//         return list.size()==0 ? -1 : list.remove(list.size()-1);
//     }
    
//     public void increment(int k, int val) {
//         for(int i=0; i<Math.min(k, list.size()); ++i)
//             list.set(i, list.get(i)+val);
//     }
// }

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */