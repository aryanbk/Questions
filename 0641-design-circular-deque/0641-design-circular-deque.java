class MyCircularDeque {
    Deque<Integer> dq;
    int k;
    public MyCircularDeque(int k) {
        dq = new ArrayDeque<>(k);
        this.k = k;
    }
    
    public boolean insertFront(int value) {
        return dq.size()==k ? false : dq.offerFirst(value);
    }
    
    public boolean insertLast(int value) {
        return dq.size()==k ? false : dq.offerLast(value);
    }
    
    public boolean deleteFront() {
        return dq.pollFirst() != null;
    }
    
    public boolean deleteLast() {
        return dq.pollLast() != null;
    }
    
    public int getFront() {
        var ans = dq.peekFirst();
        return ans==null ? -1 : ans;
    }
    
    public int getRear() {
        var ans = dq.peekLast();
        return ans==null ? -1 : ans;
    }
    
    public boolean isEmpty() {
        return dq.isEmpty();
    }
    
    public boolean isFull() {
        return dq.size()==k;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */