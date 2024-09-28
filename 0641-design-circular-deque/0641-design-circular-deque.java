class MyCircularDeque extends ArrayDeque<Integer> {
    int k;
    
    public MyCircularDeque(int k) {
        super(k);
        this.k = k;
    }
    
    public boolean insertFront(int value) {
        return super.size()==k ? false : super.offerFirst(value);
    }
    
    public boolean insertLast(int value) {
        return super.size()==k ? false : super.offerLast(value);
    }
    
    public boolean deleteFront() {
        return super.pollFirst() != null;
    }
    
    public boolean deleteLast() {
        return super.pollLast() != null;
    }
    
    public int getFront() {
        return super.peekFirst() == null ? -1 : super.peekFirst();
    }
    
    public int getRear() {
        return super.peekLast() == null ? -1 : super.peekLast();
    }
    
    public boolean isEmpty() {
        return super.isEmpty();
    }
    
    public boolean isFull() {
        return super.size()==k;
    }
}






// class MyCircularDeque {
//     Deque<Integer> super;
//     int k;
//     public MyCircularDeque(int k) {
//         super = new ArrayDeque<>(k);
//         this.k = k;
//     }
    
//     public boolean insertFront(int value) {
//         return super.size()==k ? false : super.offerFirst(value);
//     }
    
//     public boolean insertLast(int value) {
//         return super.size()==k ? false : super.offerLast(value);
//     }
    
//     public boolean deleteFront() {
//         return super.pollFirst() != null;
//     }
    
//     public boolean deleteLast() {
//         return super.pollLast() != null;
//     }
    
//     public int getFront() {
//         var ans = super.peekFirst();
//         return ans==null ? -1 : ans;
//     }
    
//     public int getRear() {
//         var ans = super.peekLast();
//         return ans==null ? -1 : ans;
//     }
    
//     public boolean isEmpty() {
//         return super.isEmpty();
//     }
    
//     public boolean isFull() {
//         return super.size()==k;
//     }
// }

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